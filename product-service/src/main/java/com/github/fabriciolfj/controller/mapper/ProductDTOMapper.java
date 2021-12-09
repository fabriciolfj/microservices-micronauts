package com.github.fabriciolfj.controller.mapper;

import com.github.fabriciolfj.controller.dto.ProductRequest;
import com.github.fabriciolfj.controller.dto.ProductResponse;
import com.github.fabriciolfj.entities.Product;

import java.util.UUID;

public class ProductDTOMapper {

    private ProductDTOMapper() {

    }

    public static Product toEntity(final ProductRequest request) {
        return Product
                .builder()
                .code(UUID.randomUUID().toString())
                .price(request.getPrice())
                .name(request.getName())
                .quantity(request.getQuantity())
                .category(CategoryDTOMapper.toEntity(request.getCategory()))
                .build();
    }

    public static ProductResponse toResponse(final Product product) {
        return ProductResponse
                .builder()
                .code(product.getCode())
                .build();
    }

    public static ProductResponse toResponse(final String code) {
        return ProductResponse
                .builder()
                .code(code)
                .build();
    }
}
