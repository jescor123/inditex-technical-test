package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PhotoService {
    Set<Photo> findPhotosById(long id);
    Photo savePhoto(Photo photo);
    Set<Photo> getPhotosFromApi();
    void savePhotosFromApi();

}
