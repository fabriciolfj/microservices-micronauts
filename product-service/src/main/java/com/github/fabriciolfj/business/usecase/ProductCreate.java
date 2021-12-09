package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.DeleteProduct;
import com.github.fabriciolfj.business.InventaryCreate;
import com.github.fabriciolfj.business.SaveProduct;
import com.github.fabriciolfj.entities.Product;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ProductCreate {

    private final SaveProduct saveProduct;
    private final DeleteProduct deleteProduct;
    private final InventaryCreate inventaryCreate;

    public String execute(final Product product) {
        saveProduct.save(product);
        return processInventory(product);
    }

    private String processInventory(Product entity) {
        try {
            inventaryCreate.setInventory(entity);
            return entity.getCode();
        } catch (Exception e) {
            deleteProduct.remove(entity.getCode());
            throw new RuntimeException("Fail create product. Details: " + e.getMessage());
        }
    }
}
