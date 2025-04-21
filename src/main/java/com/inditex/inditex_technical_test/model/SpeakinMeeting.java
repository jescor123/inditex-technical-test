package com.inditex.inditex_technical_test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "SPEAKINGS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpeakinMeeting {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "MEETING_TIME")
    private String meetingTime;
    @Column(name = "MEETING_LINK")
    private String meetingLink;
    @Column(name = "INFORMATION_VIDEO")
    private String informationVideo;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

}
