package com.inditex.inditex_technical_test.repository;

import com.inditex.inditex_technical_test.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    @Query("SELECT p FROM Photo p WHERE p.albumId = :id")
    List<Photo> findPhotosByAlbumId(@Param("id") long id);

}
