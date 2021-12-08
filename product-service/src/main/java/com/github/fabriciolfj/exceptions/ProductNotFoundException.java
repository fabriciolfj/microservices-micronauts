package com.github.fabriciolfj.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(final String msg) {
        super("Product not found: " + msg);
    }
}
