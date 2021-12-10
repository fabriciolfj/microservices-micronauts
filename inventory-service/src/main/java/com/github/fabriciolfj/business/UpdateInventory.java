package com.github.fabriciolfj.business;

import com.github.fabriciolfj.providers.database.InventoryDataBaseProvider;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class UpdateInventory {

    private final InventoryDataBaseProvider provider;

    public void execute(final String code, final Long quantity) {
        log.info("Enviando o produto {}, para atualizar a quantidade {}", code, quantity);
        provider.update(code, quantity);
    }
}
