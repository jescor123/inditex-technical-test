package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.AlbumDTO;
import com.inditex.inditex_technical_test.dto.ConfirmationDTO;
import com.inditex.inditex_technical_test.exception.AlbumDataInternalServerErrorException;
import com.inditex.inditex_technical_test.mapper.AlbumMapper;
import com.inditex.inditex_technical_test.mapper.PhotoMapper;
import com.inditex.inditex_technical_test.model.Album;
import com.inditex.inditex_technical_test.model.Photo;
import com.inditex.inditex_technical_test.service.AlbumService;
import com.inditex.inditex_technical_test.service.DataCollectionService;
import com.inditex.inditex_technical_test.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {
    AlbumService albumService;
    PhotoService photoService;

    public DataCollectionServiceImpl(AlbumService albumService, PhotoService photoService) {
        this.albumService = albumService;
        this.photoService = photoService;
    }

    @Override
    public Flux<AlbumDTO> getDataFromDatabase() {

        try {

            return Flux.fromIterable(albumService.findAllAlbums().stream()
                    .map(album -> AlbumMapper.mapToAlbumDto(album,
                            photoService.findPhotosById(album.getId()).stream()
                                    .map(PhotoMapper::mapToPhotoDto)
                                    .toList()))
                    .toList());

        } catch (Exception e) {
            throw new AlbumDataInternalServerErrorException();
        }

    }

    @Override
    public Mono<ConfirmationDTO> saveDataInDatabase() {

        try {

            albumService.saveAlbumsFromApi();
            photoService.savePhotosFromApi();
            return Mono.just(new ConfirmationDTO(String.valueOf(HttpStatus.OK), HttpStatus.OK.name()));

        } catch (Exception e) {
            throw new AlbumDataInternalServerErrorException();
        }

    }

    @Override
    public Flux<AlbumDTO> getAlbumsFromApi() {

        try {

            Set<Album> albumList = albumService.getAlbumsFromApi();
            Set<Photo> photoList =  photoService.getPhotosFromApi();

            return Flux.fromIterable(albumList.stream()
                    .map(album -> AlbumMapper.mapToAlbumDto(album,
                            photoList.stream().filter(photo -> photo.getAlbumId() == album.getId())
                                    .map(PhotoMapper::mapToPhotoDto)
                                    .toList()))
                    .toList());

        } catch (Exception e) {
            throw new AlbumDataInternalServerErrorException();
        }

    }

}
