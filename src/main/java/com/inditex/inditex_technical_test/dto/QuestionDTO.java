package com.inditex.inditex_technical_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionDTO {
    private long id;
    private long idCategory;
    private String description1;
    private String answer;
    private String description2;
    private Set<ComboBoxOptionDTO> comboBoxOptionDTOSet;
    private Timestamp lastUpdate;

}
