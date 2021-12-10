package com.github.fabriciolfj.providers.database;

import com.github.fabriciolfj.entities.Inventory;
import com.github.fabriciolfj.exceptions.InventoryNotFoundException;
import com.github.fabriciolfj.providers.database.mapper.InventoryMapper;
import com.github.fabriciolfj.providers.database.model.InventoryData;
import com.github.fabriciolfj.providers.database.repository.InventoryRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

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

    @Transactional(Transactional.TxType.REQUIRED)
    public void update(final String code, final Long quantity) {
        repository
                .findByCodeLastDate(code)
                .map(inv -> InventoryData.builder()
                        .balance(quantity)
                        .code(code)
                        .dateMov(LocalDateTime.now())
                        .entrance(0L)
                        .exit(0L)
                        .build())
                .map(repository::save)
                .orElseThrow(() -> new InventoryNotFoundException(code));
    }
}
