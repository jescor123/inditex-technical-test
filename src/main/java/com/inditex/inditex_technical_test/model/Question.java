package com.inditex.inditex_technical_test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "QUESTIONS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "ID_CATEGORY")
    private long idCategory;

    @Column(name = "DESCRIPTION1")
    private String description1;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "DESCRIPTION2")
    private String description2;

    @Column(name = "URL_FILE_NAME")
    private String urlFileName;

    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

}
