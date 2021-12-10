package com.github.fabriciolfj.providers.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductQuantityDTO {

    private String code;
    private Long quantity;
}
