package com.company.product;

public class LED implements Display{
    @Override
    public String getDisplayName() {
        return "LED Matrix";
    }

    @Override
    public int getDisplayCost() {
        return 170;
    }
}
