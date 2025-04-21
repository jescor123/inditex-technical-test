package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.ComboBoxOptionDTO;
import com.inditex.inditex_technical_test.model.ComboBoxOption;
import com.inditex.inditex_technical_test.repository.ComboBoxOptionRepository;
import com.inditex.inditex_technical_test.service.ComboBoxOptionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ComboBoxOptionServiceImpl implements ComboBoxOptionService {
    private ComboBoxOptionRepository comboBoxOptionRepository;

    public ComboBoxOptionServiceImpl(ComboBoxOptionRepository comboBoxOptionRepository) {
        this.comboBoxOptionRepository = comboBoxOptionRepository;
    }

    @Override
    public List<ComboBoxOptionDTO> findAllComboBoxOptions() {
        return null;
    }

    @Override
    public Optional<ComboBoxOption> findComboBoxOptionById(long id) {
        return Optional.empty();
    }

    @Override
    public ComboBoxOption saveComboBoxOption(ComboBoxOption comboBoxOption) {
        return comboBoxOptionRepository.save(comboBoxOption);
    }

    @Override
    public List<ComboBoxOption> saveComboBoxOptions(Set<ComboBoxOption> comboBoxOptionSet) {
        return comboBoxOptionRepository.saveAll(comboBoxOptionSet);
    }
}
