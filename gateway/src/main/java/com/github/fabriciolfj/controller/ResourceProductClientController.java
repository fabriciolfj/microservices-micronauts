package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.web.ProductResourceClient;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;

@Controller("/api/v1/product")
public class ResourceProductClientController {

    @Inject
    private ProductResourceClient client;

    @Get("/{code}")
    public HttpResponse findProduct(@PathVariable("code") final String code) {
        return client.findByCode(code);
    }
}
