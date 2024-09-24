package com.inditex.inditex_technical_test.service;

import com.inditex.inditex_technical_test.dto.CategoryDTO;
import com.inditex.inditex_technical_test.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface CategoryService {

    List<CategoryDTO> findAllCategories();
    Optional<Category> findCategoryById(long id);
    Category saveCategory(Category category);
    List<Category> saveCategories(Set<Category> CategorySet);

}
