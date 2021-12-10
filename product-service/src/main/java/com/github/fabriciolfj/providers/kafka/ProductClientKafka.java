package com.github.fabriciolfj.providers.kafka;

import com.github.fabriciolfj.providers.kafka.dto.ProductQuantityDTO;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface ProductClientKafka {

    @Topic("product-quantity")
    void send(ProductQuantityDTO dto);

}
