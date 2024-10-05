package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.QuestionDTO;
import com.inditex.inditex_technical_test.dto.ResponsePostDTO;
import com.inditex.inditex_technical_test.exception.AlbumDataInternalServerErrorException;
import com.inditex.inditex_technical_test.mapper.CheckBoxOptionMapper;
import com.inditex.inditex_technical_test.mapper.ComboBoxOptionMapper;
import com.inditex.inditex_technical_test.mapper.QuestionMapper;
import com.inditex.inditex_technical_test.model.CheckBoxOption;
import com.inditex.inditex_technical_test.model.ComboBoxOption;
import com.inditex.inditex_technical_test.model.Question;
import com.inditex.inditex_technical_test.repository.ComboBoxOptionRepository;
import com.inditex.inditex_technical_test.repository.QuestionRepository;
import com.inditex.inditex_technical_test.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    private ComboBoxOptionServiceImpl comboBoxOptionService;

    private CheckBoxOptionServiceImpl checkBoxOptionService;

    public QuestionServiceImpl(QuestionRepository questionRepository,
                               ComboBoxOptionServiceImpl comboBoxOptionService,
                               CheckBoxOptionServiceImpl checkBoxOptionService) {
        this.questionRepository = questionRepository;
        this.comboBoxOptionService = comboBoxOptionService;
        this.checkBoxOptionService = checkBoxOptionService;
    }

    @Override
    public List<QuestionDTO> findAllQuestions() {

        return List.copyOf(questionRepository.findAll().stream().map(question -> QuestionMapper.mapToQuestionDto(question)).toList());

    }

    @Override
    public Optional<Question> findQuestionById(long id) {

        return questionRepository.findById(id);

    }

    @Override
    public Mono<ResponsePostDTO> saveQuestion(QuestionDTO questionDTO) {

        try {

            questionRepository.save(QuestionMapper.mapToQuestion(questionDTO));
            if (questionDTO.getComboBoxOptionDTOSet() != null && questionDTO.getIdCategory() == 2) {
                Set<ComboBoxOption> comboBoxOptionSet = questionDTO.
                        getComboBoxOptionDTOSet().
                        stream().
                        map(combo -> ComboBoxOptionMapper.mapToComboBoxOption(combo)).
                        collect(Collectors.toSet());
                comboBoxOptionService.saveComboBoxOptions(comboBoxOptionSet);
            }
            if (questionDTO.getCheckBoxOptionDTOSet() != null && questionDTO.getIdCategory() == 3) {
                Set<CheckBoxOption> checkBoxOptionSet = questionDTO
                        .getCheckBoxOptionDTOSet().
                        stream().
                        map(check -> CheckBoxOptionMapper.mapToCheckBoxOption(check)).
                        collect(Collectors.toSet());
                checkBoxOptionService.saveCheckBoxOptions(checkBoxOptionSet);
            }

            return Mono.just(new ResponsePostDTO(String.valueOf(HttpStatus.OK), HttpStatus.OK.name()));

        } catch (Exception e) {
            throw new AlbumDataInternalServerErrorException();
        }

    }

    @Override
    public List<Question> saveQuestions(Set<Question> questionSet) {

        return questionRepository.saveAll(questionSet);

    }

}
