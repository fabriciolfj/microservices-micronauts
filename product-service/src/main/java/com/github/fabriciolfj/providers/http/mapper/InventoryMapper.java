package com.github.fabriciolfj.providers.http.mapper;

import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.providers.http.dto.InventoryRequestDTO;

public class InventoryMapper {

    private InventoryMapper() {

    }

    public static InventoryRequestDTO toDto(final Product product) {
        return InventoryRequestDTO
                .builder()
                .product(product.getCode())
                .quantity(product.getQuantity())
                .build();
    }
}
