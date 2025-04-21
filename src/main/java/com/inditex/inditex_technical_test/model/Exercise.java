package com.inditex.inditex_technical_test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "EXERCISES")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exercise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

}
