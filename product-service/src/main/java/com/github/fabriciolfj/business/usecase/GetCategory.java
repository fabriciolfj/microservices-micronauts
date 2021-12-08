package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindCategory;
import com.github.fabriciolfj.entities.Category;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class GetCategory {

    private final FindCategory findCategory;

    public Category execute(final String code) {
        return findCategory.find(code);
    }
}
