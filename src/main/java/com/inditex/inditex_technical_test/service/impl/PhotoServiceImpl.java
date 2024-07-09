package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.exception.AlbumDataInternalServerErrorException;
import com.inditex.inditex_technical_test.model.Photo;
import com.inditex.inditex_technical_test.repository.PhotoRepository;
import com.inditex.inditex_technical_test.service.PhotoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PhotoServiceImpl implements PhotoService {

    private PhotoRepository photoRepository;
    private WebClient webClient;

    @Value("${inditex.api.uri2}")
    private String apiUri;
    public PhotoServiceImpl(PhotoRepository photoRepository, WebClient webClient) {
        this.photoRepository = photoRepository;
        this.webClient = webClient;
    }

    @Override
    public List<Photo> findPhotosById(long id) {

        return photoRepository.findPhotosByAlbumId(id);

    }

    @Override
    public List<Photo> savePhotos(Set<Photo> photoSet) {

        return photoRepository.saveAll(photoSet);

    }

    @Override
    public Set<Photo> getPhotosFromApi() {

        Flux<Photo> photoFlux = webClient.get()
                .uri(apiUri)
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> Mono.error(new AlbumDataInternalServerErrorException()))
                .bodyToFlux(Photo.class)
                .onErrorResume(Exception.class, exception -> Flux.empty());

        photoFlux.subscribe();

        return new LinkedHashSet<>(new ArrayList<>(
                Objects.requireNonNull(photoFlux.collectList().block())));

    }

    @Override
    public void savePhotosFromApi() {

        savePhotos(getPhotosFromApi().stream().collect(Collectors.toSet()));

    }


}
