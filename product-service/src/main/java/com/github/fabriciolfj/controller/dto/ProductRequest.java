package com.github.fabriciolfj.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotNull(message = "Name not informed")
    private String name;
    @Positive(message = "Price greater zero")
    private BigDecimal price;
    private String category;
    private Long quantity;
}
