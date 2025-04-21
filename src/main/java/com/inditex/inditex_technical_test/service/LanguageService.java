package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.dto.LanguageDTO;
import com.inditex.inditex_technical_test.model.Language;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface LanguageService {
    Flux<LanguageDTO> findAllLanguages();
    Optional<Language> findLanguageById(long id);
    Language saveLanguage(Language language);
    List<Language> saveLanguages(Set<Language> languageSet);

}
