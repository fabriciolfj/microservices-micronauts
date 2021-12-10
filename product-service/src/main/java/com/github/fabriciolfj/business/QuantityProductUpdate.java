package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.Product;

public interface QuantityProductUpdate {

    void sendInventoryNewQuantity(final Product product);
}
