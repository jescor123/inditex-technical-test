package com.inditex.inditex_technical_test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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
