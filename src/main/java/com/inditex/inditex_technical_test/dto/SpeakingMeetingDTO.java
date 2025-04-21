package com.inditex.inditex_technical_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpeakingMeetingDTO {
    private long id;
    private String name;
    private String description;
    private String meetingTime;
    private String meetingLink;
    private String informationVideo;
    private String userId;
    private Timestamp lastUpdate;

}
