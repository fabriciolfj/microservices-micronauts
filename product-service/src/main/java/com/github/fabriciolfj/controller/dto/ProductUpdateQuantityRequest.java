package com.github.fabriciolfj.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductUpdateQuantityRequest {

    private String code;
    private Long quantity;
}
