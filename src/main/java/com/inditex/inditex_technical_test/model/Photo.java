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
@Table(name = "PHOTOS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Photo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "ALBUM_ID")
    private long albumId;
    @Column(name = "TITLE")
    private String title;

    @Column(name = "URL")
    private String url;

    @Column(name = "THUMBNAIL_URL")
    private String thumbnailUrl;

}
