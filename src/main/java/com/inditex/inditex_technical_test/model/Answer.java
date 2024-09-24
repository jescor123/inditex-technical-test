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
@Table(name = "ANSWERS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "ID_CATEGORY")
    private long idCategory;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

}
