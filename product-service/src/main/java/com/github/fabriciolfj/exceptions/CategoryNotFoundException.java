package com.github.fabriciolfj.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(final String msg) {
        super("Category not found: " + msg);
    }
}
