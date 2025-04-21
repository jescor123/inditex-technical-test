package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.ExerciseDTO;
import com.inditex.inditex_technical_test.dto.ResponsePostDTO;
import com.inditex.inditex_technical_test.mapper.ExerciseMapper;
import com.inditex.inditex_technical_test.model.Exercise;
import com.inditex.inditex_technical_test.repository.ExerciseRepository;
import com.inditex.inditex_technical_test.service.ExerciseService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<ExerciseDTO> findAllExercises() {

        return List.copyOf(exerciseRepository.findAll().stream().map(exercise -> ExerciseMapper.mapToExerciseDto(exercise)).toList());

    }

    @Override
    public Optional<Exercise> findExerciseById(long id) {
        return Optional.empty();
    }

    @Override
    public Mono<ResponsePostDTO> saveExercise(ExerciseDTO exerciseDTO) {
        return null;
    }

    @Override
    public List<Exercise> saveExercises(Set<Exercise> exerciseSet) {
        return null;
    }

}
