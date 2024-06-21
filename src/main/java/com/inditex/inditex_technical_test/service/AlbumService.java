package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.model.Album;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public interface AlbumService {
    List<Album> findAllAlbums();
    Album saveAlbum(Album album);
    Flux<Album> getAlbumsFromApi();
    boolean saveAlbumsFromApi();

}
