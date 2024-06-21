package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.exception.SpaceShipInternalServerErrorException;
import com.inditex.inditex_technical_test.model.Album;
import com.inditex.inditex_technical_test.repository.AlbumRepository;
import com.inditex.inditex_technical_test.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private WebClient webClient;

    @Override
    public Page<Album> findAllAlbums(Pageable pageable) {

        return albumRepository.findAll(pageable);

    }

    @Override
    public Optional<Album> findAlbumById(long id) {

        return albumRepository.findById(id);

    }

    @Override
    public Album saveAlbum(Album album) {

        return albumRepository.save(album);

    }

    @Override
    public Flux<Album> getAlbumsFromApi() {

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

        return albums;

    }


    @Override
    public String saveAlbumsFromApi() {

        Flux<Album> albums = getAlbumsFromApi();
        Mono<List<Album>> monoAlbumList = albums.collectList();
        List<Album> albumList = monoAlbumList.block();
        for (Album album: albumList) {
            saveAlbum(album);
        }
        return "Albums saved in H2";

    }

    private Mono<? extends Throwable> handleErrorResponse(HttpStatus statusCode) {

        // Handle non-success status codes here (e.g., logging or custom error handling)
        return Mono.error(new SpaceShipInternalServerErrorException());

    }

}
