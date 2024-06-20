package com.inditex.inditex_technical_test.controller;

import com.inditex.inditex_technical_test.exception.SpaceShipInternalServerErrorException;
import com.inditex.inditex_technical_test.exception.SpaceShipNotContentException;
import com.inditex.inditex_technical_test.model.Album;
import com.inditex.inditex_technical_test.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v2")
public class AlbumDataController {
    @Autowired
    AlbumService albumService;
    @GetMapping(value = "/albums-from-h2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAlbumsFromDatabase(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        try {

            Pageable paging = PageRequest.of(page, size);
            Page<Album> pageableResult = albumService.findAllAlbums(paging);
            List<Album> albums = pageableResult.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("albums", albums);
            response.put("currentPage", pageableResult.getNumber());
            response.put("totalItems", pageableResult.getTotalElements());
            response.put("totalPages", pageableResult.getTotalPages());

            if (response != null && !response.isEmpty()) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                throw new SpaceShipNotContentException();
            }

        } catch (Exception e) {
            throw new SpaceShipInternalServerErrorException();
        }
   }

    @GetMapping(value = "/save-albums-in-database", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveAlbumsInDatabase() {
        try {

            // I will do my best, always
            String response = albumService.saveAlbumsFromApi();

            if (response != null && !response.isEmpty()) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                throw new SpaceShipNotContentException();
            }

        } catch (Exception e) {
            throw new SpaceShipInternalServerErrorException();
        }
    }

    @GetMapping(value = "/albums-from-api", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Album> getAlbumsFromApi() {

        return albumService.getAlbumsFromApi();

    }

}
