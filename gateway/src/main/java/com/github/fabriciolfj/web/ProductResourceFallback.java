package com.github.fabriciolfj.web;

import com.github.fabriciolfj.dto.ProductResponse;
import io.micronaut.http.HttpResponse;
import io.micronaut.retry.annotation.Fallback;

@Fallback
public class ProductResourceFallback implements ProductResourceClient {

    @Override
    public HttpResponse<ProductResponse> findByCode(String code) {
        return HttpResponse.ok(new ProductResponse());
    }
}
