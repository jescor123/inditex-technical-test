package com.inditex.inditex_technical_test.repository;

import com.inditex.inditex_technical_test.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
