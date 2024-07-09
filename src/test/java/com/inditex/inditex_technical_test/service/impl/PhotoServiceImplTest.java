package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.model.Photo;
import com.inditex.inditex_technical_test.repository.PhotoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PhotoServiceImplTest {

    @InjectMocks
    private PhotoServiceImpl photoService;

    @Mock
    private PhotoRepository photoRepository;

    private Set<Photo> photoSet = new LinkedHashSet<>();

    private List<Photo> photoList = new ArrayList<>();


    @BeforeEach
    public void setUp() {

        Photo photo1 = new Photo();
        photo1.setId(1);
        photo1.setAlbumId(1);
        photo1.setTitle("XXX");
        photo1.setUrl("XXX");
        photo1.setThumbnailUrl("XXX");

        Photo photo2 = new Photo();
        photo2.setId(2);
        photo2.setAlbumId(1);
        photo2.setTitle("XXX");
        photo2.setUrl("XXX");
        photo2.setThumbnailUrl("XXX");

        Photo photo3 = new Photo();
        photo3.setId(3);
        photo3.setAlbumId(1);
        photo3.setTitle("XXX");
        photo3.setUrl("XXX");
        photo3.setThumbnailUrl("XXX");

        photoList.add(photo1);
        photoList.add(photo2);
        photoList.add(photo3);

        photoSet.add(photo1);
        photoSet.add(photo2);
        photoSet.add(photo3);

    }

    @Test
    void test_findPhotosById() {

        List<Photo> list = new ArrayList<>();
        list.add(new Photo(1, 1, "XXX", "XXX", "XXX"));
        list.add(new Photo(2, 1, "XXX", "XXX", "XXX"));
        list.add(new Photo(3, 1, "XXX", "XXX", "XXX"));

        Mockito.when(photoRepository.findPhotosByAlbumId(1)).thenReturn(photoList);
        var photosFromDB = photoService.findPhotosById(1);
        assertEquals(photosFromDB, list);

    }

    @Test
    void test_savePhotosFromApi() {

        List<Photo> list = new ArrayList<>();
        list.add(new Photo(1, 1, "XXX", "XXX", "XXX"));
        list.add(new Photo(2, 1, "XXX", "XXX", "XXX"));
        list.add(new Photo(3, 1, "XXX", "XXX", "XXX"));

        Mockito.when(photoRepository.saveAll(photoSet)).thenReturn(list);
        var photoFromDB = photoService.savePhotos(photoSet);
        assertEquals(photoFromDB.get(0).getId(), list.get(0).getId());
        assertEquals(photoFromDB.get(0).getAlbumId(), list.get(0).getAlbumId());
        assertEquals(photoFromDB.get(0).getTitle(), list.get(0).getTitle());
        assertEquals(photoFromDB.get(0).getUrl(), list.get(0).getUrl());
        assertEquals(photoFromDB.get(0).getThumbnailUrl(), list.get(0).getThumbnailUrl());

    }

}