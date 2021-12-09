package com.github.fabriciolfj.providers.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestDTO {

    private Long quantity;
    private String product;
}
