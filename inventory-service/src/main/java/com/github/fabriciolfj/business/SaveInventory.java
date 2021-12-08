package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.Inventory;
import com.github.fabriciolfj.providers.database.InventoryDataBaseProvider;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class SaveInventory {

    private final InventoryDataBaseProvider provider;

    public String save(final Inventory inventory) {
        try {
            var inv = provider.findByCode(inventory.getCode());
            inventory.calculateBalance(inv.getBalance());

            provider.save(inventory);
            return inventory.getCode();
        } catch (Exception e) {
            provider.save(inventory);
            return inventory.getCode();
        }
    }
}
