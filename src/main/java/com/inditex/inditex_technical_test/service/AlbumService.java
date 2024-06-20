package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service
public interface AlbumService {
    Page<Album> findAllAlbums(Pageable pageable);
    Optional<Album> findAlbumById(long id);
    Album saveAlbum(Album album);
    Flux<Album> getAlbumsFromApi();
    String saveAlbumsFromApi();

}
