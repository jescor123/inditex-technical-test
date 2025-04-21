package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.QuestionDTO;
import com.inditex.inditex_technical_test.model.Question;

public class QuestionMapper {
    private QuestionMapper() { }

    public static QuestionDTO mapToQuestionDto(Question question) {

        return new QuestionDTO(
                question.getId(),
                question.getIdExercise(),
                question.getIdCategory(),
                question.getDescription1(),
                question.getAnswer(),
                question.getDescription2(),
                question.getUrlFileName(),
                null,
                null,
                question.getLastUpdate()
        );

    }

    public static Question mapToQuestion(QuestionDTO questionDTO){

        return new Question(
                questionDTO.getId(),
                1,
                questionDTO.getIdCategory(),
                questionDTO.getDescription1(),
                questionDTO.getAnswer(),
                questionDTO.getDescription2(),
                questionDTO.getUrlFileName(),
                questionDTO.getLastUpdate()
        );

    }
    
}
