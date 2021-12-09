package com.github.fabriciolfj.providers.http;

import com.github.fabriciolfj.business.InventaryCreate;
import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.providers.http.dto.InventoryResponseDTO;
import com.github.fabriciolfj.providers.http.mapper.InventoryMapper;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@Singleton
public class InventoryHttpProvider implements InventaryCreate {

    @Value("${inventory.host}")
    private String host;

    @Override
    public void setInventory(final Product product) throws MalformedURLException {
        var dto = InventoryMapper.toDto(product);
        var client = HttpClient.create(new URL(host));
        var result= client.toBlocking().retrieve(HttpRequest.POST("/api/v1/inventories/entrance", dto), InventoryResponseDTO.class);

        log.info("Result inventory: {}", result);
    }
}
