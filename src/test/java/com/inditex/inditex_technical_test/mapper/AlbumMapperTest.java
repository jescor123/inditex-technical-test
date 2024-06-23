package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.AlbumDTO;
import com.inditex.inditex_technical_test.dto.PhotoDTO;
import com.inditex.inditex_technical_test.model.Album;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlbumMapperTest {

    private Album albumToCompare;
    private AlbumDTO albumDTOtoCompare;

    private Set<PhotoDTO> photoList = new HashSet<>();

    @BeforeEach
    public void setUp() {

        albumToCompare = new Album();
        albumToCompare.setId(1);
        albumToCompare.setUserId(1);
        albumToCompare.setTitle("XXX");

        PhotoDTO photo = new PhotoDTO();
        photo.setId(1);
        photo.setAlbumId(1);
        photo.setTitle("XXX");
        photo.setUrl("XXX");
        photo.setThumbnailUrl("XXX");
        photoList.add(photo);

        albumDTOtoCompare = new AlbumDTO();
        albumDTOtoCompare.setId(1);
        albumDTOtoCompare.setUserId(1);
        albumDTOtoCompare.setTitle("XXX");
        albumDTOtoCompare.setPhotoList(photoList);

    }

    @Test
    void mapToAlbumDto() {

        Album album = new Album(1, 1, "XXX");
        assertEquals(AlbumMapper.mapToAlbumDto(album, photoList), albumDTOtoCompare);

    }

    @Test
    void mapToAlbum() {

        AlbumDTO albumDTO = new AlbumDTO(1, 1, "XXX", photoList);
        assertEquals(AlbumMapper.mapToAlbum(albumDTO), albumToCompare);

    }
}