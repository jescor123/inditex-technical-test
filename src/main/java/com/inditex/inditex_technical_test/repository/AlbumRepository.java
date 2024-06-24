package com.inditex.inditex_technical_test.repository;

import com.inditex.inditex_technical_test.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
