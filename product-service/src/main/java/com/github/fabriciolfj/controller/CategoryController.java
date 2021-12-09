package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.FindCategory;
import com.github.fabriciolfj.business.usecase.CategoryCreate;
import com.github.fabriciolfj.controller.dto.CategoryRequest;
import com.github.fabriciolfj.controller.mapper.CategoryDTOMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api/v1/category")
public class CategoryController {

    private final CategoryCreate categoryCreate;
    private final FindCategory findCategory;

    @Get("/{code}")
    public HttpResponse find(@PathVariable("code") final String code) {
        var response = CategoryDTOMapper.toResponse(findCategory.find(code));
        return HttpResponse.ok(response);
    }

    @Post
    public HttpResponse create(final CategoryRequest request) {
        var category = CategoryDTOMapper.toEntity(request);
        var response = CategoryDTOMapper.toResponse(categoryCreate.execute(category));
        return HttpResponse.ok(response);
    }
}
