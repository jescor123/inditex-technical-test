package com.inditex.inditex_technical_test.mapper;

import com.inditex.inditex_technical_test.dto.CategoryDTO;
import com.inditex.inditex_technical_test.model.Category;

public class CategoryMapper {
    private CategoryMapper() {}

    public static CategoryDTO mapToCategoryDto(Category category) {

        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getLastUpdate()
        );

    }

    public static Category mapToCategory(CategoryDTO categoryDTO){

        return new Category(
                categoryDTO.getId(),
                categoryDTO.getName(),
                categoryDTO.getLastUpdate()
        );

    }


}
