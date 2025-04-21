package com.inditex.inditex_technical_test.controller;

import com.inditex.inditex_technical_test.message.ResponseMessage;
import com.inditex.inditex_technical_test.model.FileInfo;
import com.inditex.inditex_technical_test.service.FilesStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v2")
@CrossOrigin
public class FilesController {
    private final String path = "C:\\Users\\jescor\\Documents\\GIT-LOCAL-REPO\\inditex-technical-test\\recording-files\\";
    private final String recordingFileName = "readingImage.jpg";
    FilesStorageService storageService;
    public FilesController(FilesStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/upload-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String message = "";
        try {

            deleteFile(recordingFileName);
            storageService.save(file);
            renameFile(file.getOriginalFilename());
            ResponseEntity<ResponseMessage> answer = ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            if (answer.getStatusCode().is2xxSuccessful())
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {

        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/fileByName")
    public ResponseEntity<Optional<FileInfo>> getListFileByName(@RequestParam("filename") String filename) {

        Optional<FileInfo> fileInfo = storageService.loadAll().map(path -> {
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", filename).build().toString();
            return new FileInfo(filename, url);
        }).findAny();

        return ResponseEntity.status(HttpStatus.OK).body(fileInfo);

    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {

        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);

    }

    @GetMapping("/imageBlob/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {

        File file = new File(path+imageName);
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        fis.close();
        byte[] imageBytes = bos.toByteArray();
        // Set the content type based on the image file extension
        String contentType = "image/jpeg"; // or "image/png"
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(contentType))
                .body(imageBytes);

    }

    public boolean deleteFile(String recordingFileName)  {

        File recordingFile = new File(path+recordingFileName);
        boolean isDeleted = recordingFile.delete();
        return isDeleted;

    }

    public boolean renameFile(String originalFileName)  {

        File originalFile = new File(path+originalFileName);
        boolean isRenamed = originalFile.renameTo(new File(path+recordingFileName));
        return isRenamed;

    }


}
