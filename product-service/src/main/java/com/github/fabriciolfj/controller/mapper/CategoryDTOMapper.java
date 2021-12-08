package com.github.fabriciolfj.controller.mapper;

import com.github.fabriciolfj.controller.dto.CategoryRequest;
import com.github.fabriciolfj.controller.dto.CategoryResponse;
import com.github.fabriciolfj.entities.Category;

import java.util.UUID;

public class CategoryDTOMapper {

    private CategoryDTOMapper() {

    }

    public static Category toEntity(final CategoryRequest request) {
        return Category
                .builder()
                .name(request.getName())
                .code(UUID.randomUUID().toString())
                .build();
    }

    public static Category toEntity(final String code) {
        return Category
                .builder()
                .code(code)
                .build();
    }

    public static CategoryResponse toResponse(final String code) {
        return CategoryResponse
                .builder()
                .code(code)
                .build();
    }

    public static CategoryResponse toResponse(final Category category) {
        return CategoryResponse
                .builder()
                .code(category.getCode())
                .build();
    }
}
