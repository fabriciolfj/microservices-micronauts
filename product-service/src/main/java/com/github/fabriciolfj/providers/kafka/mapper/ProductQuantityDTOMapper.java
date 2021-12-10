package com.github.fabriciolfj.providers.kafka.mapper;

import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.providers.kafka.dto.ProductQuantityDTO;

public class ProductQuantityDTOMapper {

    private ProductQuantityDTOMapper() {

    }

    public static ProductQuantityDTO toDTO(final Product product) {
        return ProductQuantityDTO
                .builder()
                .quantity(product.getQuantity())
                .code(product.getCode())
                .build();
    }
}
