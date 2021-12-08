package com.github.fabriciolfj.providers.database.repository;

import com.github.fabriciolfj.providers.database.model.InventoryData;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryData, Long> {

    @Query("Select i From InventoryData i where i.code = :p1 and i.dateMov = (Select max(i2.dateMov) From InventoryData i2 where i2.code = :p1)")
    Optional<InventoryData> findByCodeLastDate(@Parameter("p1") final String code);
}
