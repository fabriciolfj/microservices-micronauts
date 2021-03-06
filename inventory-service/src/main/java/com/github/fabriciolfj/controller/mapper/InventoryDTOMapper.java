package com.github.fabriciolfj.controller.mapper;

import com.github.fabriciolfj.controller.dto.*;
import com.github.fabriciolfj.entities.Inventory;

import java.time.LocalDateTime;

public class InventoryDTOMapper {

    private InventoryDTOMapper() {

    }

    public static InventoryResponseCodeDTO toResponse(final String code) {
        return InventoryResponseCodeDTO
                .builder()
                .code(code)
                .build();
    }

    public static InventoryResponseDTO toResponse(final Inventory inventory) {
        return InventoryResponseDTO.builder()
                .balance(inventory.getBalance())
                .dateMov(inventory.getDateMov().toString())
                .entrance(inventory.getEntrance())
                .exit(inventory.getExit())
                .build();
    }

    public static InventoryResponseV2DTO toResponseV2(final Inventory inventory) {
        return InventoryResponseV2DTO.builder()
                .code(inventory.getCode())
                .balance(inventory.getBalance())
                .dateMov(inventory.getDateMov().toString())
                .entrance(inventory.getEntrance())
                .exit(inventory.getExit())
                .build();
    }

    public static Inventory toEntity(final InventoryRequestEntranceDTO dto) {
        return Inventory.builder()
                .entrance(dto.getQuantity())
                .exit(0L)
                .balance(dto.getQuantity())
                .code(dto.getProduct())
                .dateMov(LocalDateTime.now())
                .build();
    }

    public static Inventory toEntity(final InventoryRequestExitDTO dto) {
        return Inventory.builder()
                .entrance(0L)
                .balance(dto.getQuantity())
                .exit(dto.getQuantity())
                .code(dto.getProduct())
                .dateMov(LocalDateTime.now())
                .build();
    }
}
