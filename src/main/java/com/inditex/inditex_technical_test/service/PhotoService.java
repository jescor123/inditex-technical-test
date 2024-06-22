package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.model.Photo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhotoService {
    List<Photo> findPhotosById(long id);
    Photo savePhoto(Photo photo);
    List<Photo> getPhotosFromApi();
    void savePhotosFromApi();

}
