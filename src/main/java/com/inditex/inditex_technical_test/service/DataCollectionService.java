package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.dto.AlbumDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public interface DataCollectionService {
    Flux<AlbumDTO> getDataFromDatabase();
    String saveDataInDatabase();
    Flux<AlbumDTO> getAlbumsFromApi();

}
