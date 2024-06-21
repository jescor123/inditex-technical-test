package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.model.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public interface PhotoService {
    List<Photo> findPhotosById(long id);
    Photo savePhoto(Photo photo);
    Flux<Photo> getPhotosFromApi();
    boolean savePhotosFromApi();

}
