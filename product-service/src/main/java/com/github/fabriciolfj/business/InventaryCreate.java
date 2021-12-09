package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.Product;

import java.net.MalformedURLException;

public interface InventaryCreate {

    void setInventory(final Product product) throws MalformedURLException;
}
