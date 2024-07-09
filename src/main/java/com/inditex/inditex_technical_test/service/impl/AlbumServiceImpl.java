package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.exception.AlbumDataInternalServerErrorException;
import com.inditex.inditex_technical_test.model.Album;
import com.inditex.inditex_technical_test.repository.AlbumRepository;
import com.inditex.inditex_technical_test.service.AlbumService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private AlbumRepository albumRepository;
    private WebClient webClient;
    @Value("${inditex.api.uri1}")
    private String apiUri;
    public AlbumServiceImpl(AlbumRepository albumRepository, WebClient webClient) {
        this.albumRepository = albumRepository;
        this.webClient = webClient;
    }

    @Override
    public Set<Album> findAllAlbums() {

        return new LinkedHashSet<>(albumRepository.findAll());

    }

    @Override
    public List<Album> saveAlbums(Set<Album> albumSet) {

        return albumRepository.saveAll(albumSet);

    }

    @Override
    public Set<Album> getAlbumsFromApi() {

        Flux<Album> albumFlux = webClient.get()
                .uri(apiUri)
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> Mono.error(new AlbumDataInternalServerErrorException()))
                .bodyToFlux(Album.class)
                .onErrorResume(Exception.class, exception -> Flux.empty());

        albumFlux.subscribe();

        return new LinkedHashSet<>(new ArrayList<>(
                 Objects.requireNonNull(albumFlux.collectList().block())));

    }

    @Override
    public void saveAlbumsFromApi() {

        saveAlbums(getAlbumsFromApi().stream().collect(Collectors.toSet()));

    }


}
