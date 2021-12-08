package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.QueryProduct;
import com.github.fabriciolfj.business.usecase.ProductCreate;
import com.github.fabriciolfj.controller.dto.ProductRequest;
import com.github.fabriciolfj.controller.mapper.ProductDTOMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller("/api/v1/products")
public class ProductController {

    private final ProductCreate productCreate;
    private final QueryProduct queryProduct;

    @Post
    public HttpResponse create(final ProductRequest request) {
        var product = ProductDTOMapper.toEntity(request);
        var response = ProductDTOMapper.toResponse(productCreate.execute(product));

        return HttpResponse.ok(response);
    }

    @Get("/{code}")
    public HttpResponse find(@PathVariable("code") final String code) {
        var response = ProductDTOMapper.toResponse(queryProduct.findCode(code));

        return HttpResponse.ok(response);
    }
}
