package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.SpeakingMeetingDTO;
import com.inditex.inditex_technical_test.model.SpeakinMeeting;

public class SpeakingMeetingMapper {
    public SpeakingMeetingMapper() {}

    public static SpeakingMeetingDTO mapToSpeakingMeetingDTO(SpeakinMeeting speakinMeeting) {

        return new SpeakingMeetingDTO(
                speakinMeeting.getId(),
                speakinMeeting.getName(),
                speakinMeeting.getDescription(),
                speakinMeeting.getMeetingTime(),
                speakinMeeting.getMeetingLink(),
                speakinMeeting.getInformationVideo(),
                speakinMeeting.getUserId(),
                speakinMeeting.getLastUpdate()
        );

    }

    public static SpeakinMeeting mapToSpeakinMeeting(SpeakingMeetingDTO speakingMeetingDTO) {

        return new SpeakinMeeting(
                speakingMeetingDTO.getId(),
                speakingMeetingDTO.getName(),
                speakingMeetingDTO.getDescription(),
                speakingMeetingDTO.getMeetingTime(),
                speakingMeetingDTO.getMeetingLink(),
                speakingMeetingDTO.getInformationVideo(),
                speakingMeetingDTO.getUserId(),
                speakingMeetingDTO.getLastUpdate()
        );

    }

}
