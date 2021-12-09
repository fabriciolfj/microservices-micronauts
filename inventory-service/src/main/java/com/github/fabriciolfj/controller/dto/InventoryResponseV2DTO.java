package com.github.fabriciolfj.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponseV2DTO {

    private String code;
    private Long balance;
    private String dateMov;
    private Long exit;
    private Long entrance;
}
