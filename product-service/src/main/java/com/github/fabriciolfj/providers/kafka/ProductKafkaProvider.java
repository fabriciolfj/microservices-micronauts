package com.github.fabriciolfj.providers.kafka;

import com.github.fabriciolfj.business.QuantityProductUpdate;
import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.providers.kafka.mapper.ProductQuantityDTOMapper;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Singleton
public class ProductKafkaProvider implements QuantityProductUpdate {

    private final ProductClientKafka clientKafka;

    @Override
    public void sendInventoryNewQuantity(final Product product) {
        clientKafka.send(ProductQuantityDTOMapper.toDTO(product));
    }
}
