package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.PhotoDTO;
import com.inditex.inditex_technical_test.model.Photo;

public class PhotoMapper {

    private PhotoMapper() {}

    public static PhotoDTO mapToPhotoDto(Photo photo){

        return new PhotoDTO(
                photo.getId(),
                photo.getAlbumId(),
                photo.getTitle(),
                photo.getUrl(),
                photo.getThumbnailUrl()
        );

    }

    public static Photo mapToPhoto(PhotoDTO photoDTO){

        return new Photo(
                photoDTO.getId(),
                photoDTO.getAlbumId(),
                photoDTO.getTitle(),
                photoDTO.getUrl(),
                photoDTO.getThumbnailUrl()
        );

    }

}
