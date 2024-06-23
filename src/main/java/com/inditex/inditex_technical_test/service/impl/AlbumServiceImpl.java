package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.exception.AlbumDataInternalServerErrorException;
import com.inditex.inditex_technical_test.model.Album;
import com.inditex.inditex_technical_test.repository.AlbumRepository;
import com.inditex.inditex_technical_test.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private WebClient webClient;

    @Override
    public Set<Album> findAllAlbums() {

        return new HashSet<>(albumRepository.findAll());

    }

    @Override
    public Album saveAlbum(Album album) {

        return albumRepository.save(album);

    }

    @Override
    public Set<Album> getAlbumsFromApi() {

        Flux<Album> albums = webClient.get()
                .uri("/albums")
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> handleErrorResponse((HttpStatus) clientResponse.statusCode()))
                .bodyToFlux(Album.class)
                .onErrorResume(Exception.class, e -> Flux.empty());

        albums.subscribe(album -> {
            // Process each album in the Flux
            System.out.println("Album: " + album);
        });

        return new HashSet<>(albums.collectList().block());

    }

    @Override
    public void saveAlbumsFromApi() {

        getAlbumsFromApi().stream().forEach(album -> saveAlbum(album));

    }

    private Mono<? extends Throwable> handleErrorResponse(HttpStatus statusCode) {

        return Mono.error(new AlbumDataInternalServerErrorException());

    }

}
