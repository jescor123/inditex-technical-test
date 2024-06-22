package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.exception.AlbumDataInternalServerErrorException;
import com.inditex.inditex_technical_test.model.Photo;
import com.inditex.inditex_technical_test.repository.PhotoRepository;
import com.inditex.inditex_technical_test.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private WebClient webClient;

    @Override
    public List<Photo> findPhotosById(long id) {

        return photoRepository.findPhotosByAlbumId(id);

    }

    @Override
    public Photo savePhoto(Photo photo) {

        return photoRepository.save(photo);

    }

    @Override
    public List<Photo> getPhotosFromApi() {

        Flux<Photo> photos = webClient.get()
                .uri("/photos")
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> handleErrorResponse((HttpStatus) clientResponse.statusCode()))
                .bodyToFlux(Photo.class)
                .onErrorResume(Exception.class, e -> Flux.empty());

        photos.subscribe(photo -> {
            // Process each photo in the Flux
            System.out.println("Photo: " + photo);
        });

        return photos.collectList().block();

    }

    @Override
    public void savePhotosFromApi() {

        List<Photo> photoList = getPhotosFromApi();
        for (Photo photo: photoList) {
            savePhoto(photo);
        }

    }

    private Mono<? extends Throwable> handleErrorResponse(HttpStatus statusCode) {

        return Mono.error(new AlbumDataInternalServerErrorException());

    }

}
