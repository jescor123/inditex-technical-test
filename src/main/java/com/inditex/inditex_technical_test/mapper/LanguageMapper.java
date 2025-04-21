package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.*;
import com.inditex.inditex_technical_test.model.Language;

import java.util.List;

public class LanguageMapper {

    private LanguageMapper() {}

    public static LanguageDTO mapToLanguageDto(Language language, List<AnswerDTO> answerDTOList, List<CategoryDTO> catAnswerDTOList,
                                               List<QuestionDTO> questionDTOList, List<ComboBoxOptionDTO> comboBoxOptionDTOList,
                                               List<CheckBoxOptionDTO> checkBoxOptionDTOList) {

        return new LanguageDTO(
                language.getId(),
                language.getName(),
                answerDTOList,
                catAnswerDTOList,
                questionDTOList,
                comboBoxOptionDTOList,
                checkBoxOptionDTOList,
                language.getLastUpdate()
        );

    }

    public static Language mapToLanguage(LanguageDTO languageDTO){

        return new Language(
                languageDTO.getId(),
                languageDTO.getDescription(),
                languageDTO.getLastUpdate()
        );

    }


}
