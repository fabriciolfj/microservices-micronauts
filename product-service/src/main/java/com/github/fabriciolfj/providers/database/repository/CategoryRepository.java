package com.github.fabriciolfj.providers.database.repository;

import com.github.fabriciolfj.providers.database.model.CategoryModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    Optional<CategoryModel> findByCode(final String code);
}
