package com.github.fabriciolfj.providers.database;

import com.github.fabriciolfj.entities.Inventory;
import com.github.fabriciolfj.exceptions.InventoryNotFoundException;
import com.github.fabriciolfj.providers.database.mapper.InventoryMapper;
import com.github.fabriciolfj.providers.database.repository.InventoryRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class InventoryDataBaseProvider {

    private final InventoryRepository repository;

    public void save(final Inventory inventory) {
        repository.save(InventoryMapper.toData(inventory));
    }

    public Inventory findByCode(final String code) {
        return repository
                .findByCodeLastDate(code)
                .map(InventoryMapper::toEntity)
                .orElseThrow(() -> new InventoryNotFoundException(code));
    }
}
