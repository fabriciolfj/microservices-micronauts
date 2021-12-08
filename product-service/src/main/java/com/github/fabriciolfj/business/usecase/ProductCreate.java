package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.SaveProduct;
import com.github.fabriciolfj.entities.Product;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ProductCreate {

    private final SaveProduct saveProduct;

    public String execute(final Product product) {
        return saveProduct.save(product);
    }
}
