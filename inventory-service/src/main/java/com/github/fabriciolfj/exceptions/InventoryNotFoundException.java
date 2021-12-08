package com.github.fabriciolfj.exceptions;

public class InventoryNotFoundException extends RuntimeException {

    public InventoryNotFoundException(final String msg) {
        super("Inventory not found, code: " + msg);
    }
}
