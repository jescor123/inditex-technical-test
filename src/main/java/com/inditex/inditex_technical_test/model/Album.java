package com.inditex.inditex_technical_test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "ALBUMS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "TITLE")
    private String title;

}
