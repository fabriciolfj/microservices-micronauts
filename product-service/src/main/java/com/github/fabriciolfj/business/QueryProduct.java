package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.Product;

import java.util.List;

public interface QueryProduct {

    Product findCode(final String code);
}
