package com.github.fabriciolfj.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestEntranceDTO {

    private Long quantity;
    private String product;
}
