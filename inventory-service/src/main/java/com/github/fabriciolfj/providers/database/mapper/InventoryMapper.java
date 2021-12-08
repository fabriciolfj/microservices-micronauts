package com.github.fabriciolfj.providers.database.mapper;

import com.github.fabriciolfj.entities.Inventory;
import com.github.fabriciolfj.providers.database.model.InventoryData;

public class InventoryMapper {

    private InventoryMapper() { }

    public static Inventory toEntity(final InventoryData data) {
        return Inventory.builder()
                .balance(data.getBalance())
                .code(data.getCode())
                .dateMov(data.getDateMov())
                .exit(data.getExit())
                .entrance(data.getEntrance())
                .build();
    }

    public static InventoryData toData(final Inventory inventory) {
        return InventoryData.builder()
                .dateMov(inventory.getDateMov())
                .exit(inventory.getExit())
                .code(inventory.getCode())
                .balance(inventory.getBalance())
                .entrance(inventory.getEntrance())
                .build();
    }
}
