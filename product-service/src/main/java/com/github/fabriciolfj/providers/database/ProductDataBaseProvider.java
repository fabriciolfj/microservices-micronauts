package com.github.fabriciolfj.providers.database;

import com.github.fabriciolfj.business.DeleteProduct;
import com.github.fabriciolfj.business.QueryProduct;
import com.github.fabriciolfj.business.SaveProduct;
import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.exceptions.ProductNotFoundException;
import com.github.fabriciolfj.providers.database.mappers.ProductModelMapper;
import com.github.fabriciolfj.providers.database.repository.ProductRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

@Singleton
@RequiredArgsConstructor
@Slf4j
public class ProductDataBaseProvider implements DeleteProduct, QueryProduct, SaveProduct {

    private final ProductRepository repository;
    private final CategoryDataBaseProvider categoryDataBaseProvider;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void remove(final String code) {
        var product = repository.findByCode(code);

        if(product.isPresent()) {
            log.info("Product found: {}", product.get());
            repository.delete(product.get());
            return;
        }

        new ProductNotFoundException(code);
    }

    @Override
    public Product findCode(final String code) {
        return repository.findByCode(code)
                .map(ProductModelMapper::toEntity)
                .orElseThrow(() -> new ProductNotFoundException(code));
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public String save(final Product product) {
        log.info("Save product: {}", product);
        var productModel = ProductModelMapper.toModel(product,
                categoryDataBaseProvider.findModel(product.getCodeCategory()));

        return repository.save(productModel).getCode();
    }
}
