package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.AlbumDTO;
import com.inditex.inditex_technical_test.dto.PhotoDTO;
import com.inditex.inditex_technical_test.model.Album;

import java.util.List;

public class AlbumMapper {
    public static AlbumDTO mapToAlbumDto(Album album, List<PhotoDTO> photoList){
        AlbumDTO albumDTO = new AlbumDTO(
                album.getId(),
                album.getUserId(),
                album.getTitle(),
                photoList
        );
        return albumDTO;
    }

    public static Album mapToAlbum(AlbumDTO albumDTO){
        Album album = new Album(
                albumDTO.getId(),
                albumDTO.getUserId(),
                albumDTO.getTitle()
        );
        return album;
    }

}
