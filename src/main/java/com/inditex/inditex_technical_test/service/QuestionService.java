package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.dto.QuestionDTO;
import com.inditex.inditex_technical_test.dto.ResponsePostDTO;
import com.inditex.inditex_technical_test.model.Question;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface QuestionService {
    List<QuestionDTO> findAllQuestions();
    Optional<Question> findQuestionById(long id);
    Mono<ResponsePostDTO> saveQuestion(QuestionDTO questionDTO);
    List<Question> saveQuestions(Set<Question> questionSet);

}
