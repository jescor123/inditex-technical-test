package com.inditex.inditex_technical_test.service.impl;

import com.inditex.inditex_technical_test.dto.CategoryDTO;
import com.inditex.inditex_technical_test.mapper.CategoryMapper;
import com.inditex.inditex_technical_test.model.Category;
import com.inditex.inditex_technical_test.repository.CategoryRepository;
import com.inditex.inditex_technical_test.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository; }

    @Override
    public List<CategoryDTO> findAllCategories() {

        return List.copyOf(categoryRepository.findAll().stream().map(category -> CategoryMapper.mapToCategoryDto(category)).toList());

    }

    @Override
    public Optional<Category> findCategoryById(long id) {

        return categoryRepository.findById(id);

    }

    @Override
    public Category saveCategory(Category category) {

        return categoryRepository.save(category);

    }

    @Override
    public List<Category> saveCategories(Set<Category> categorySet) {

        return categoryRepository.saveAll(categorySet);

    }

}
