package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.CheckBoxOptionDTO;
import com.inditex.inditex_technical_test.model.CheckBoxOption;
import com.inditex.inditex_technical_test.repository.CheckBoxOptionRepository;
import com.inditex.inditex_technical_test.service.CheckBoxOptionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CheckBoxOptionServiceImpl implements CheckBoxOptionService {

    private CheckBoxOptionRepository checkBoxOptionRepository;

    public CheckBoxOptionServiceImpl(CheckBoxOptionRepository checkBoxOptionRepository) {
        this.checkBoxOptionRepository = checkBoxOptionRepository;
    }

    @Override
    public List<CheckBoxOptionDTO> findAllCheckBoxOptions() {
        return null;
    }

    @Override
    public Optional<CheckBoxOption> findCheckBoxOptionById(long id) {
        return Optional.empty();
    }

    @Override
    public CheckBoxOption saveCheckBoxOption(CheckBoxOption checkBoxOption) {
        return checkBoxOptionRepository.save(checkBoxOption);
    }

    @Override
    public List<CheckBoxOption> saveCheckBoxOptions(Set<CheckBoxOption> checkBoxOptionSet) {
        return checkBoxOptionRepository.saveAll(checkBoxOptionSet);
    }
}
