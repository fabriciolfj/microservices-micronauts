package com.github.fabriciolfj.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    private String code;
    private String name;
    private BigDecimal price;
    private Category category;

    public String getCodeCategory() {
        return category.getCode();
    }
}
