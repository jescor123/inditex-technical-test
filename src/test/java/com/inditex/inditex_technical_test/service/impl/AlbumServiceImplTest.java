package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.model.Album;
import com.inditex.inditex_technical_test.repository.AlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class AlbumServiceImplTest {

    @InjectMocks
    private AlbumServiceImpl albumService;

    @Mock
    private AlbumRepository albumRepository;

    private List<Album> albumList = new ArrayList<>();

    private Album albumtoSave = new Album(1, 1, "XXX");

    @BeforeEach
    public void setUp() {

        Album album1 = new Album();
        album1.setId(1);
        album1.setUserId(1);
        album1.setTitle("XXX");

        Album album2 = new Album();
        album2.setId(2);
        album2.setUserId(1);
        album2.setTitle("XXX");

        Album album3 = new Album();
        album3.setId(3);
        album3.setUserId(1);
        album3.setTitle("XXX");

        albumList.add(album1);
        albumList.add(album2);
        albumList.add(album3);

    }
    @Test
    void test_when_findAllAlbums_Is_Ok() {

        Set<Album> list = new HashSet<>();
        list.add(new Album(1, 1, "XXX"));
        list.add(new Album(2, 1, "XXX"));
        list.add(new Album(3, 1, "XXX"));

        Mockito.when(albumRepository.findAll()).thenReturn(albumList);
        var albumsFromDB = albumService.findAllAlbums();
        assertTrue(albumsFromDB.equals(list));

    }

    @Test
    void test_when_saveAlbumsFromApi_Is_Ok() {

        Album album = new Album(1, 1, "XXX");
        Mockito.when(albumRepository.save(album)).thenReturn(album);
        var albumFromDB = albumService.saveAlbum(albumtoSave);
        assertEquals(albumFromDB.getId(), album.getId());
        assertEquals(albumFromDB.getUserId(), album.getUserId());
        assertEquals(albumFromDB.getTitle(), album.getTitle());

    }

}