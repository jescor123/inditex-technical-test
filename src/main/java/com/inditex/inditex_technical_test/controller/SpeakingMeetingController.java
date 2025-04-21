package com.inditex.inditex_technical_test.controller;

import com.inditex.inditex_technical_test.dto.SpeakingMeetingDTO;
import com.inditex.inditex_technical_test.service.SpeakingMeetingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v2")
@CrossOrigin
public class SpeakingMeetingController {

    private SpeakingMeetingService speakingMeetingService;

    public SpeakingMeetingController(SpeakingMeetingService speakingMeetingService) {
        this.speakingMeetingService = speakingMeetingService;
    }

    @GetMapping(value = "/speaking-meeting-set", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<SpeakingMeetingDTO> getSpeakingMeetingDTOFlux() {

        try {

            Flux<SpeakingMeetingDTO> response = speakingMeetingService.findAllSpeakingMeetingDtoList();

            if (response != null) {
                return response;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
