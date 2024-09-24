package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.dto.ComboBoxOptionDTO;
import com.inditex.inditex_technical_test.model.ComboBoxOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface ComboBoxOptionService {
    List<ComboBoxOptionDTO> findAllComboBoxOptions();
    Optional<ComboBoxOption> findComboBoxOptionById(long id);
    ComboBoxOption saveComboBoxOption(ComboBoxOption comboBoxOption);
    List<ComboBoxOption> saveComboBoxOptions(Set<ComboBoxOption> comboBoxOptionSet);

}
