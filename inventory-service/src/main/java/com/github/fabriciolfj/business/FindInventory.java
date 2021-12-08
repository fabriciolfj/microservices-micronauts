package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.Inventory;
import com.github.fabriciolfj.providers.database.InventoryDataBaseProvider;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class FindInventory {

    private final InventoryDataBaseProvider provider;

    public Inventory findByCode(final String code) {
        return provider.findByCode(code);
    }
}
