package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.CheckBoxOptionDTO;
import com.inditex.inditex_technical_test.model.CheckBoxOption;

public class CheckBoxOptionMapper {

    public CheckBoxOptionMapper() { }

    public static CheckBoxOptionDTO mapToCheckBoxOptionDto(CheckBoxOption checkBoxOption) {

        return new CheckBoxOptionDTO(
                checkBoxOption.getId(),
                checkBoxOption.getIdCategory(),
                checkBoxOption.getIdQuestion(),
                checkBoxOption.getDescription(),
                checkBoxOption.getLastUpdate()
        );

    }

    public static CheckBoxOption mapToCheckBoxOption(CheckBoxOptionDTO checkBoxOptionDTO){

        return new CheckBoxOption(
                checkBoxOptionDTO.getId(),
                checkBoxOptionDTO.getIdCategory(),
                checkBoxOptionDTO.getIdQuestion(),
                checkBoxOptionDTO.getDescription(),
                checkBoxOptionDTO.getLastUpdate()
        );

    }
    
}
