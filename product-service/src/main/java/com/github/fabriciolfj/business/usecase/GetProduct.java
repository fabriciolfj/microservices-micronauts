package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.QueryProduct;
import com.github.fabriciolfj.entities.Product;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class GetProduct {

    private final QueryProduct queryProduct;

    public Product execute(final String code) {
        return queryProduct.findCode(code);
    }
}
