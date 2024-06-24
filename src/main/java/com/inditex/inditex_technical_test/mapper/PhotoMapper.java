package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.PhotoDTO;
import com.inditex.inditex_technical_test.model.Photo;

public class PhotoMapper {

    public static PhotoDTO mapToPhotoDto(Photo photo){
        PhotoDTO photoDTO = new PhotoDTO(
                photo.getId(),
                photo.getAlbumId(),
                photo.getTitle(),
                photo.getUrl(),
                photo.getThumbnailUrl()
        );
        return photoDTO;
    }

    public static Photo mapToPhoto(PhotoDTO photoDTO){
        Photo photo = new Photo(
                photoDTO.getId(),
                photoDTO.getAlbumId(),
                photoDTO.getTitle(),
                photoDTO.getUrl(),
                photoDTO.getThumbnailUrl()
        );
        return photo;
    }

}
