package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.dto.AnswerDTO;
import com.inditex.inditex_technical_test.model.Answer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface AnswerService {

    List<AnswerDTO> findAllAnswers();
    Optional<Answer> findAnswerById(long id);
    Answer saveAnswer(Answer answer);
    List<Answer> saveAnswers(Set<Answer> AnswerSet);
    
}
