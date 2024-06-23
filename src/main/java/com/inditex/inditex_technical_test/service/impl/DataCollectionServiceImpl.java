package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.AlbumDTO;
import com.inditex.inditex_technical_test.dto.ConfirmationDTO;
import com.inditex.inditex_technical_test.mapper.AlbumMapper;
import com.inditex.inditex_technical_test.mapper.PhotoMapper;
import com.inditex.inditex_technical_test.model.Album;
import com.inditex.inditex_technical_test.model.Photo;
import com.inditex.inditex_technical_test.service.AlbumService;
import com.inditex.inditex_technical_test.service.DataCollectionService;
import com.inditex.inditex_technical_test.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {
    @Autowired
    AlbumService albumService;
    @Autowired
    PhotoService photoService;

    @Override
    public Flux<AlbumDTO> getDataFromDatabase() {

        return Flux.fromIterable(albumService.findAllAlbums().stream()
                .map(album -> AlbumMapper.mapToAlbumDto(album,
                        photoService.findPhotosById(album.getId()).stream()
                                .map(photo -> PhotoMapper.mapToPhotoDto(photo))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList()));

    }

    @Override
    public Mono<ConfirmationDTO> saveDataInDatabase() {

        albumService.saveAlbumsFromApi();
        photoService.savePhotosFromApi();
        return Mono.just(new ConfirmationDTO(String.valueOf(HttpStatus.OK), HttpStatus.OK.name()));

    }

    @Override
    public Flux<AlbumDTO> getAlbumsFromApi() {

        List<Album> albumList = albumService.getAlbumsFromApi();
        List<Photo> photoList =  photoService.getPhotosFromApi();

        return Flux.fromIterable(albumList.stream()
                .map(album -> AlbumMapper.mapToAlbumDto(album,
                        photoList.stream().filter(photo -> photo.getAlbumId() == album.getId())
                                .map(photo -> PhotoMapper.mapToPhotoDto(photo))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList()));

    }

}
