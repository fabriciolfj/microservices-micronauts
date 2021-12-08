package com.github.fabriciolfj.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestExitDTO {

    private Long quantity;
    private String product;
}
