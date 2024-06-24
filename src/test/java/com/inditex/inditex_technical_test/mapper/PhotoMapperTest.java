package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.PhotoDTO;
import com.inditex.inditex_technical_test.model.Photo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhotoMapperTest {

    private Photo photoToCompare;
    private PhotoDTO photoDTOtoCompare;

    @BeforeEach
    public void setUp() {

        photoToCompare = new Photo();
        photoToCompare.setId(1);
        photoToCompare.setAlbumId(1);
        photoToCompare.setTitle("XXX");
        photoToCompare.setUrl("XXX");
        photoToCompare.setThumbnailUrl("XXX");

        photoDTOtoCompare = new PhotoDTO();
        photoDTOtoCompare.setId(1);
        photoDTOtoCompare.setAlbumId(1);
        photoDTOtoCompare.setTitle("XXX");
        photoDTOtoCompare.setUrl("XXX");
        photoDTOtoCompare.setThumbnailUrl("XXX");

    }

    @Test
    void mapToPhotoDto() {

        Photo photo = new Photo(1, 1, "XXX", "XXX", "XXX");
        assertEquals(PhotoMapper.mapToPhotoDto(photo), photoDTOtoCompare);

    }

    @Test
    void mapToPhoto() {

        PhotoDTO photoDTO = new PhotoDTO(1, 1, "XXX", "XXX", "XXX");
        assertEquals(PhotoMapper.mapToPhoto(photoDTO), photoToCompare);

    }
}