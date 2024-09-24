package com.inditex.inditex_technical_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LanguageDTO {
    private long id;
    private String description;
    private List<AnswerDTO> answerDTOList;
    private List<CategoryDTO> categoryDTOList;
    private List<QuestionDTO> questionDTOList;
    private List<ComboBoxOptionDTO> comboBoxOptionDTOList;
    private Timestamp lastUpdate;

}
