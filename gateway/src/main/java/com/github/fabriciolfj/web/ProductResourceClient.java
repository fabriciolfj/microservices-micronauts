package com.github.fabriciolfj.web;

import com.github.fabriciolfj.dto.ProductResponse;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;

//@Retryable(attempts = "5", delay = "2s", multiplier = "1.5", maxDelay = "20s")
@CircuitBreaker(delay = "5s", attempts = "3", multiplier = "2", reset = "300s")
@Client(id = "product-service")
public interface ProductResourceClient {


    @Get("/api/v1/products/{code}")
    HttpResponse<ProductResponse> findByCode(@PathVariable("code") final String code);
}
