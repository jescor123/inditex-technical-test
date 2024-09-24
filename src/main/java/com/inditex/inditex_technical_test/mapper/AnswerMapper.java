package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.AnswerDTO;
import com.inditex.inditex_technical_test.model.Answer;

public class AnswerMapper {
    private AnswerMapper() { }


    public static AnswerDTO mapToAnswerDto(Answer answer) {

        return new AnswerDTO(
                answer.getId(),
                answer.getIdCategory(),
                answer.getDescription(),
                answer.getLastUpdate()
        );

    }

    public static Answer mapToAnswer(AnswerDTO answerDTO){

        return new Answer(
                answerDTO.getId(),
                answerDTO.getIdCategory(),
                answerDTO.getDescription(),
                answerDTO.getLastUpdate()
        );

    }


}
