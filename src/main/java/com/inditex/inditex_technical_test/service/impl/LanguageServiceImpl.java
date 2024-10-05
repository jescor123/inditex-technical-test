package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.LanguageDTO;
import com.inditex.inditex_technical_test.mapper.*;
import com.inditex.inditex_technical_test.model.Language;
import com.inditex.inditex_technical_test.repository.*;
import com.inditex.inditex_technical_test.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LanguageServiceImpl implements LanguageService {

    private LanguageRepository languageRepository;

    private AnswerRepository answerRepository;

    private CategoryRepository categoryRepository;

    private QuestionRepository questionRepository;

    private ComboBoxOptionRepository comboBoxOptionRepository;

    private CheckBoxOptionRepository checkBoxOptionRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository, AnswerRepository answerRepository,
                               CategoryRepository categoryRepository, QuestionRepository questionRepository,
                               ComboBoxOptionRepository comboBoxOptionRepository,
                               CheckBoxOptionRepository checkBoxOptionRepository) {

        this.languageRepository = languageRepository;
        this.answerRepository = answerRepository;
        this.categoryRepository = categoryRepository;
        this.questionRepository = questionRepository;
        this.comboBoxOptionRepository = comboBoxOptionRepository;
        this.checkBoxOptionRepository = checkBoxOptionRepository;

    }

    @Override
    public Flux<LanguageDTO> findAllLanguages() {

        return Flux.fromIterable(languageRepository.findAll().stream()
                .map(language -> LanguageMapper.mapToLanguageDto(language,
                        List.copyOf(answerRepository.findAll().stream().map(AnswerMapper::mapToAnswerDto).toList()),
                        List.copyOf(categoryRepository.findAll().stream().map(CategoryMapper::mapToCategoryDto).toList()),
                        List.copyOf(questionRepository.findAll().stream().map(QuestionMapper::mapToQuestionDto).toList()),
                        List.copyOf(comboBoxOptionRepository.findAll().stream().map(ComboBoxOptionMapper::mapToComboBoxOptionDto).toList()),
                        List.copyOf(checkBoxOptionRepository.findAll().stream().map(CheckBoxOptionMapper::mapToCheckBoxOptionDto).toList())
                        ))
                .toList());

    }

    @Override
    public Optional<Language> findLanguageById(long id) {

        return languageRepository.findById(id);

    }

    @Override
    public Language saveLanguage(Language language) {

        return languageRepository.save(language);

    }

    @Override
    public List<Language> saveLanguages(Set<Language> languageSet) {

        return languageRepository.saveAll(languageSet);

    }

}
