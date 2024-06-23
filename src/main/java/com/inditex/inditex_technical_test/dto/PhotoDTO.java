package com.inditex.inditex_technical_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PhotoDTO {
    private long id;
    private long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

}
