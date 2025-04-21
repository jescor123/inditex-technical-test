package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.dto.SpeakingMeetingDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public interface SpeakingMeetingService {
    Flux<SpeakingMeetingDTO> findAllSpeakingMeetingDtoList();

}
