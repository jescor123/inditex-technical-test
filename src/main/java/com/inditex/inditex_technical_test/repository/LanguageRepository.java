package com.inditex.inditex_technical_test.repository;

import com.inditex.inditex_technical_test.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
