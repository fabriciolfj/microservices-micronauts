package com.github.fabriciolfj.providers.database.mappers;

import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.providers.database.model.CategoryModel;
import com.github.fabriciolfj.providers.database.model.ProductModel;

public class ProductModelMapper {

    private ProductModelMapper() {

    }

    public static ProductModel toModel(final Product product, final CategoryModel categoryModel) {
        return ProductModel
                .builder()
                .name(product.getName())
                .price(product.getPrice())
                .code(product.getCode())
                .category(categoryModel)
                .build();
    }

    public static Product toEntity(final ProductModel productModel) {
        return Product
                .builder()
                .code(productModel.getCode())
                .category(CategoryModelMapper.toEntity(productModel.getCategory()))
                .build();
    }
}
