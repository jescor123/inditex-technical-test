package com.inditex.inditex_technical_test.dto;


import com.inditex.inditex_technical_test.model.Photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlbumDTO {
    private long id;
    private long userId;
    private String title;
    private List<PhotoDTO> photoList;

}
