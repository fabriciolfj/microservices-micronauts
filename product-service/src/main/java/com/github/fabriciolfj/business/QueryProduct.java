package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.Product;

public interface QueryProduct {

    Product findCode(final String code);
}
