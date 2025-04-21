package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.dto.ExerciseDTO;
import com.inditex.inditex_technical_test.dto.ResponsePostDTO;
import com.inditex.inditex_technical_test.model.Exercise;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface ExerciseService {

    List<ExerciseDTO> findAllExercises();
    Optional<Exercise> findExerciseById(long id);
    Mono<ResponsePostDTO> saveExercise(ExerciseDTO exerciseDTO);
    List<Exercise> saveExercises(Set<Exercise> exerciseSet);

}
