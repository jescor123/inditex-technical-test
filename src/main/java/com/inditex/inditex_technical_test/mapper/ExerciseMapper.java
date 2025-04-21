package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.ExerciseDTO;
import com.inditex.inditex_technical_test.model.Exercise;

public class ExerciseMapper {
    public ExerciseMapper() {}

    public static ExerciseDTO mapToExerciseDto(Exercise exercise) {

        return new ExerciseDTO(
                exercise.getId(),
                exercise.getDescription(),
                exercise.getUserId(),
                null,
                exercise.getLastUpdate()
        );

    }

    public static Exercise mapToExercise(ExerciseDTO exerciseDTO){

        return new Exercise(
                exerciseDTO.getId(),
                exerciseDTO.getDescription(),
                exerciseDTO.getUserId(),
                exerciseDTO.getLastUpdate()
        );

    }

}
