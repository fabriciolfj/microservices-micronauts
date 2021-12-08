package com.github.fabriciolfj.providers.database;

import com.github.fabriciolfj.business.FindCategory;
import com.github.fabriciolfj.business.SaveCategory;
import com.github.fabriciolfj.entities.Category;
import com.github.fabriciolfj.exceptions.CategoryNotFoundException;
import com.github.fabriciolfj.providers.database.mappers.CategoryModelMapper;
import com.github.fabriciolfj.providers.database.model.CategoryModel;
import com.github.fabriciolfj.providers.database.repository.CategoryRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class CategoryDataBaseProvider implements SaveCategory, FindCategory {

    private final CategoryRepository categoryRepository;

    @Override
    public Category find(final String code) {
        return CategoryModelMapper.toEntity(findModel(code));
    }

    @Override
    public String save(final Category category) {
        log.info("Save category: {}", category);
        categoryRepository.save(CategoryModelMapper.toModel(category));
        return category.getCode();
    }

    public CategoryModel findModel(final String code) {
        return categoryRepository.findByCode(code)
                .orElseThrow(() -> new CategoryNotFoundException(code));
    }
}
