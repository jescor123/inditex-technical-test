package com.inditex.inditex_technical_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CheckBoxOptionDTO {

    private long id;

    private long idCategory;

    private long idQuestion;

    private String description;

    private Timestamp lastUpdate;

}
