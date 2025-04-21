package com.inditex.inditex_technical_test.controller;

import com.inditex.inditex_technical_test.dto.ExerciseDTO;
import com.inditex.inditex_technical_test.service.ExerciseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v2")
@CrossOrigin
public class ExerciseController {
    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping(value = "/list-exercises-by-userid", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ExerciseDTO> getListExercisesByUserId() {

        try {
            Flux<ExerciseDTO> response = (Flux<ExerciseDTO>) exerciseService.findAllExercises();

            if (response != null) {
                return response;
            } else {
                throw new RuntimeException();
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

}
