package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.ComboBoxOptionDTO;
import com.inditex.inditex_technical_test.model.ComboBoxOption;

public class ComboBoxOptionMapper {

    private ComboBoxOptionMapper() { }


    public static ComboBoxOptionDTO mapToComboBoxOptionDto(ComboBoxOption comboBoxOption) {

        return new ComboBoxOptionDTO(
                comboBoxOption.getId(),
                comboBoxOption.getIdCategory(),
                comboBoxOption.getIdQuestion(),
                comboBoxOption.getDescription(),
                comboBoxOption.getLastUpdate()
        );

    }

    public static ComboBoxOption mapToComboBoxOption(ComboBoxOptionDTO comboBoxOptionDTO){

        return new ComboBoxOption(
                comboBoxOptionDTO.getId(),
                comboBoxOptionDTO.getIdCategory(),
                comboBoxOptionDTO.getIdQuestion(),
                comboBoxOptionDTO.getDescription(),
                comboBoxOptionDTO.getLastUpdate()
        );

    }


}
