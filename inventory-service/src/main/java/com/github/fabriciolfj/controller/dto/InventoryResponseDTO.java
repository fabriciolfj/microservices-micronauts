package com.github.fabriciolfj.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponseDTO {

    private Long balance;
    private String dateMov;
    private Long exit;
    private Long entrance;
}
