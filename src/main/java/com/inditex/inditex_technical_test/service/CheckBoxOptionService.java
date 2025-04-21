package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.dto.CheckBoxOptionDTO;
import com.inditex.inditex_technical_test.model.CheckBoxOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface CheckBoxOptionService {
    List<CheckBoxOptionDTO> findAllCheckBoxOptions();
    Optional<CheckBoxOption> findCheckBoxOptionById(long id);
    CheckBoxOption saveCheckBoxOption(CheckBoxOption CheckBoxOption);
    List<CheckBoxOption> saveCheckBoxOptions(Set<CheckBoxOption> CheckBoxOptionSet);

}
