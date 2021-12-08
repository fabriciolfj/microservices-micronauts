package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.SaveCategory;
import com.github.fabriciolfj.entities.Category;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class CategoryCreate {

    private final SaveCategory saveCategory;

    public String execute(final Category category) {
        return saveCategory.save(category);
    }
}
