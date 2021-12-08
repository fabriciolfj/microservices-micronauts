package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.DeleteProduct;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ProductRemove {

    private final DeleteProduct deleteProduct;

    public void execute(final String code) {
        deleteProduct.remove(code);
    }
}
