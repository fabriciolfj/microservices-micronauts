package com.github.fabriciolfj.exceptions.handler;

import com.github.fabriciolfj.exceptions.InventoryNotFoundException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.hateoas.JsonError;
import io.micronaut.http.hateoas.Link;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;


@Produces
@Singleton
@Requires(classes = {InventoryNotFoundException.class, ExceptionHandler.class})
public class InventoryNotFoundExceptionHandler implements ExceptionHandler<InventoryNotFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, InventoryNotFoundException exception) {
        JsonError error = new JsonError(exception.getMessage());
        error.path("/" + request.getPath());
        error.link(Link.SELF, Link.of(request.getUri()));

        return HttpResponse.badRequest().body(error);
    }
}
