package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.AlbumDTO;
import com.inditex.inditex_technical_test.dto.PhotoDTO;
import com.inditex.inditex_technical_test.model.Album;
import com.inditex.inditex_technical_test.model.Photo;
import com.inditex.inditex_technical_test.service.AlbumService;
import com.inditex.inditex_technical_test.service.DataCollectionService;
import com.inditex.inditex_technical_test.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {
    @Autowired
    AlbumService albumService;
    @Autowired
    PhotoService photoService;

    @Override
    public Flux<AlbumDTO> getDataFromDatabase() {

        List<AlbumDTO> albumDTOList = new ArrayList<>();

        List<Album> albumList = albumService.findAllAlbums();
        for (Album album : albumList) {

            List<PhotoDTO> photoDTOList = new ArrayList<>();

            List<Photo> photoList = photoService.findPhotosById(album.getId());
            for (Photo photo : photoList) {
                PhotoDTO photoDTO = new PhotoDTO();
                photoDTO.setId(photo.getId());
                photoDTO.setAlbumId(photo.getAlbumId());
                photoDTO.setTitle(photo.getTitle());
                photoDTO.setUrl(photo.getUrl());
                photoDTO.setThumbnailUrl(photo.getThumbnailUrl());
                photoDTOList.add(photoDTO);
            }

            AlbumDTO albumDTO = new AlbumDTO();
            albumDTO.setId(album.getId());
            albumDTO.setUserId(album.getUserId());
            albumDTO.setTitle(album.getTitle());
            albumDTO.setPhotoList(photoDTOList);
            albumDTOList.add(albumDTO);

        }

        return Flux.fromIterable(albumDTOList);

    }

    @Override
    public String saveDataInDatabase() {

        if(albumService.saveAlbumsFromApi()){
            if (photoService.savePhotosFromApi()){
                return "200";
            }
        }
        return "500";

    }

    @Override
    public Flux<AlbumDTO> getAlbumsFromApi() {

        List<AlbumDTO> albumDTOList = new ArrayList<>();

        List<Album> albumList = albumService.getAlbumsFromApi().collectList().block();
        for (Album album : albumList) {

            List<PhotoDTO> photoDTOList = new ArrayList<>();

            List<Photo> photoList = photoService.getPhotosFromApi().collectList().block();
            for (Photo photo : photoList) {
                if (photo.getAlbumId() == album.getId()) {
                    PhotoDTO photoDTO = new PhotoDTO();
                    photoDTO.setId(photo.getId());
                    photoDTO.setAlbumId(photo.getAlbumId());
                    photoDTO.setTitle(photo.getTitle());
                    photoDTO.setUrl(photo.getUrl());
                    photoDTO.setThumbnailUrl(photo.getThumbnailUrl());
                    photoDTOList.add(photoDTO);
                }
            }

            AlbumDTO albumDTO = new AlbumDTO();
            albumDTO.setId(album.getId());
            albumDTO.setUserId(album.getUserId());
            albumDTO.setTitle(album.getTitle());
            albumDTO.setPhotoList(photoDTOList);
            albumDTOList.add(albumDTO);

        }

        return Flux.fromIterable(albumDTOList);

    }

}
