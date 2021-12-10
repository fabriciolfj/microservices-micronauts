package com.github.fabriciolfj.providers.kafka.listener;

import com.github.fabriciolfj.business.UpdateInventory;
import com.github.fabriciolfj.providers.kafka.dto.ProductQuantityDTO;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.Acknowledgement;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
@RequiredArgsConstructor
public class ProductQuantityListener {

    private final UpdateInventory updateInventory;

    @KafkaListener(groupId = "inventory-id", offsetReset = OffsetReset.EARLIEST)
    @Topic("product-quantity")
    public void receibe(final ProductQuantityDTO dto, final Acknowledgement ack) {
        try {
            log.info("Recebimento do evento: {}", dto);
            updateInventory.execute(dto.getCode(), dto.getQuantity());
            ack.ack();
        } catch (Exception e) {
            log.error("Falha no processamento do evento {}. Detalhes: {}", dto, e.getMessage());
        }
    }
}
