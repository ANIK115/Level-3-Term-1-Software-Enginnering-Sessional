package com.company.product;

public class Poor implements BuildDisplayUnit{
    DisplayUnit displayUnit = new DisplayUnit();
    @Override
    public void buildProcessor() {
        displayUnit.processor = new ATMega32();
    }

    @Override
    public void buildDisplay() {
        displayUnit.display = new LED();
    }

    @Override
    public DisplayUnit getDisplayUnit() {
        return displayUnit;
    }
}
