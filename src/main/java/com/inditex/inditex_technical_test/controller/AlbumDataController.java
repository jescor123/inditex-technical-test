package com.inditex.inditex_technical_test.controller;

import com.inditex.inditex_technical_test.dto.AlbumDTO;
import com.inditex.inditex_technical_test.exception.SpaceShipInternalServerErrorException;
import com.inditex.inditex_technical_test.exception.SpaceShipNotContentException;
import com.inditex.inditex_technical_test.service.DataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v2")
public class AlbumDataController {
    @Autowired
    DataCollectionService dataCollectionService;

    @GetMapping(value = "/albums-from-h2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<AlbumDTO> getAlbumsFromDatabase() {
        try {

            Flux<AlbumDTO> response = dataCollectionService.getDataFromDatabase();

            if (response != null) {
                return response;
            } else {
                throw new SpaceShipNotContentException();
            }

        } catch (Exception e) {
            throw new SpaceShipInternalServerErrorException();
        }
   }

    @GetMapping(value = "/save-albums-in-database", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> saveAlbumsInDatabase() {
        try {

            String response = dataCollectionService.saveDataInDatabase();

            if (response != null) {
                return Mono.just(response);
            } else {
                throw new SpaceShipNotContentException();
            }

        } catch (Exception e) {
            throw new SpaceShipInternalServerErrorException();
        }
    }

    @GetMapping(value = "/albums-from-api", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<AlbumDTO> getAlbumsFromApi() {
        try {

            Flux<AlbumDTO> response = dataCollectionService.getAlbumsFromApi();

            if (response != null) {
                return response;
            } else {
                throw new SpaceShipNotContentException();
            }

        } catch (Exception e) {
            throw new SpaceShipInternalServerErrorException();
        }
    }

}
