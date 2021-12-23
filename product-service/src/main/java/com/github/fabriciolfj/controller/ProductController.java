package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.usecase.GetProduct;
import com.github.fabriciolfj.business.usecase.ProductCreate;
import com.github.fabriciolfj.business.usecase.ProductUpdate;
import com.github.fabriciolfj.controller.dto.ProductRequest;
import com.github.fabriciolfj.controller.dto.ProductUpdateQuantityRequest;
import com.github.fabriciolfj.controller.mapper.ProductDTOMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.tracing.annotation.NewSpan;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RequiredArgsConstructor
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api/v1/products")
public class ProductController {

    private final ProductCreate productCreate;
    private final GetProduct getProduct;
    private final ProductUpdate productUpdate;

    @NewSpan
    @Put("/quantity")
    public HttpResponse updateQuantity(final ProductUpdateQuantityRequest request) {
        productUpdate.execute(ProductDTOMapper.toEntity(request));
        return HttpResponse.noContent();
    }

    @Post
    @NewSpan
    public HttpResponse create(@Valid final ProductRequest request) {
        var product = ProductDTOMapper.toEntity(request);
        var response = ProductDTOMapper.toResponse(productCreate.execute(product));

        return HttpResponse.ok(response);
    }

    @Get("/{code}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public HttpResponse find(@PathVariable("code") final String code) {
        var response = ProductDTOMapper.toResponse(getProduct.execute(code));

        return HttpResponse.ok(response);
    }
}
