package com.inditex.inditex_technical_test.repository;

import com.inditex.inditex_technical_test.model.CheckBoxOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckBoxOptionRepository extends JpaRepository<CheckBoxOption, Long> {

}
