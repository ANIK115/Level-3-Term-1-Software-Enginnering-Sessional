package com.company.product;

public class LCD implements Display{
    @Override
    public String getDisplayName() {
        return "LCD panel";
    }

    @Override
    public int getDisplayCost() {
        return 150;
    }
}
