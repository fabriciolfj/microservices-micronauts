package com.github.fabriciolfj.providers.database.mappers;

import com.github.fabriciolfj.entities.Category;
import com.github.fabriciolfj.providers.database.model.CategoryModel;

public class CategoryModelMapper {

    private CategoryModelMapper() {

    }

    public static CategoryModel toModel(final Category category) {
        return CategoryModel
                .builder()
                .code(category.getCode())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(final CategoryModel categoryModel) {
        return Category
                .builder()
                .code(categoryModel.getCode())
                .name(categoryModel.getName())
                .build();
    }

}
