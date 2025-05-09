package com.inditex.inditex_technical_test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "CHECK_BOX_OPTION")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CheckBoxOption {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "ID_CATEGORY")
    private long idCategory;

    @Column(name = "ID_QUESTION")
    private long idQuestion;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

}
