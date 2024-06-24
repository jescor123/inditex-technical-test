package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.model.Album;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface AlbumService {
    Set<Album> findAllAlbums();
    Album saveAlbum(Album album);
    Set<Album> getAlbumsFromApi();
    void saveAlbumsFromApi();

}
