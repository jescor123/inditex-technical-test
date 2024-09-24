package com.inditex.inditex_technical_test.controller;

import com.inditex.inditex_technical_test.dto.LanguageDTO;
import com.inditex.inditex_technical_test.exception.LanguageDataInternalServerErrorException;
import com.inditex.inditex_technical_test.exception.LanguageDataNotContentException;
import com.inditex.inditex_technical_test.service.LanguageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v2")
@CrossOrigin
public class LanguageDataController {

    private LanguageService languageService;

    public LanguageDataController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping(value = "/language-set", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<LanguageDTO> getLanguageFullSet() {
        try {

            Flux<LanguageDTO> response = languageService.findAllLanguages();

            if (response != null) {
                return response;
            } else {
                throw new LanguageDataNotContentException();
            }

        } catch (Exception e) {
            throw new LanguageDataInternalServerErrorException();
        }
   }

}
