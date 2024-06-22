package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.dto.AlbumDTO;
import com.inditex.inditex_technical_test.dto.ConfirmationDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface DataCollectionService {
    Flux<AlbumDTO> getDataFromDatabase();
    Mono<ConfirmationDTO> saveDataInDatabase();
    Flux<AlbumDTO> getAlbumsFromApi();

}
