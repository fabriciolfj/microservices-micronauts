package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.QuantityProductUpdate;
import com.github.fabriciolfj.entities.Product;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ProductUpdate {

    private final QuantityProductUpdate update;

    public void execute(final Product product) {
        update.sendInventoryNewQuantity(product);
    }
}
