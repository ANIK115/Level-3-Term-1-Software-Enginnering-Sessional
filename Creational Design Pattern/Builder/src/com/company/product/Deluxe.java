package com.company.product;

public class Deluxe implements BuildDisplayUnit{
    private DisplayUnit displayUnit = new DisplayUnit();

    @Override
    public void buildProcessor() {
        displayUnit.processor = new RaspberryPi();
    }

    @Override
    public void buildDisplay() {
        displayUnit.display = new LCD();
    }

    @Override
    public DisplayUnit getDisplayUnit() {
        return displayUnit;
    }
}
