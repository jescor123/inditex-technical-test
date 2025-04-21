package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.SpeakingMeetingDTO;
import com.inditex.inditex_technical_test.mapper.SpeakingMeetingMapper;
import com.inditex.inditex_technical_test.repository.SpeakingMeetingRepository;
import com.inditex.inditex_technical_test.service.SpeakingMeetingService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class SpeakingMeetingServiceImpl implements SpeakingMeetingService {

    private SpeakingMeetingRepository speakingMeetingRepository;

    public SpeakingMeetingServiceImpl(SpeakingMeetingRepository speakingMeetingRepository) {
        this.speakingMeetingRepository = speakingMeetingRepository;
    }

    @Override
    public Flux<SpeakingMeetingDTO> findAllSpeakingMeetingDtoList() {

        return Flux.fromIterable((this.speakingMeetingRepository.
                findAll().
                stream().
                map(speakinMeeting -> SpeakingMeetingMapper.mapToSpeakingMeetingDTO(speakinMeeting)).
                toList()));

    }

}
