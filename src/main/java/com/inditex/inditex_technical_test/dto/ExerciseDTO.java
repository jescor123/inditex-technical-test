package com.inditex.inditex_technical_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExerciseDTO {
    private long id;
    private String description;
    private String userId;
    private Set<QuestionDTO> questionDTOSet;
    private Timestamp lastUpdate;

}
