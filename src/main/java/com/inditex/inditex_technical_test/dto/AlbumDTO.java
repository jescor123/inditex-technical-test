package com.inditex.inditex_technical_test.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlbumDTO {
    private long id;
    private long userId;
    private String title;
    private Set<PhotoDTO> photoList;

}
