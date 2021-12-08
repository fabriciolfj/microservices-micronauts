package com.github.fabriciolfj.providers.database.repository;

import com.github.fabriciolfj.providers.database.model.ProductModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    Optional<ProductModel> findByCode(final String code);
}
