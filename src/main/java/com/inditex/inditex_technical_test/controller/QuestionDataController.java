package com.inditex.inditex_technical_test.controller;

import com.inditex.inditex_technical_test.dto.QuestionDTO;
import com.inditex.inditex_technical_test.dto.ResponsePostDTO;
import com.inditex.inditex_technical_test.exception.LanguageDataInternalServerErrorException;
import com.inditex.inditex_technical_test.exception.LanguageDataNotContentException;
import com.inditex.inditex_technical_test.service.QuestionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v2")
@CrossOrigin
public class QuestionDataController {

    private QuestionService questionService;

    public QuestionDataController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping(value = "/update-format1-questions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponsePostDTO> setFormat1Questions(@RequestBody QuestionDTO questionDTO) {
        try {

            Mono<ResponsePostDTO> response = questionService.saveQuestion(questionDTO);

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
