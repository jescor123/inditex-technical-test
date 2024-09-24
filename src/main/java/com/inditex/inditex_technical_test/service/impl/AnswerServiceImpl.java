package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.AnswerDTO;
import com.inditex.inditex_technical_test.mapper.AnswerMapper;
import com.inditex.inditex_technical_test.model.Answer;
import com.inditex.inditex_technical_test.repository.AnswerRepository;
import com.inditex.inditex_technical_test.service.AnswerService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) { this.answerRepository = answerRepository; }

    @Override
    public List<AnswerDTO> findAllAnswers() {

        return List.copyOf(answerRepository.findAll().stream().map(answer -> AnswerMapper.mapToAnswerDto(answer)).toList());

    }

    @Override
    public Optional<Answer> findAnswerById(long id) {

        return answerRepository.findById(id);

    }

    @Override
    public Answer saveAnswer(Answer answer) {

        return answerRepository.save(answer);

    }

    @Override
    public List<Answer> saveAnswers(Set<Answer> answerSet) {

        return answerRepository.saveAll(answerSet);

    }

}
