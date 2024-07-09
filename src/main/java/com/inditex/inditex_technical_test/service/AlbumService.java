package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.model.Album;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface AlbumService {
    Set<Album> findAllAlbums();
    List<Album> saveAlbums(Set<Album> albumSet);
    Set<Album> getAlbumsFromApi();
    void saveAlbumsFromApi();

}
