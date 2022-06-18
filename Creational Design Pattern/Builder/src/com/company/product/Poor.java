package com.company.product;

public class Poor implements BuildDisplayUnit{
    DisplayUnit displayUnit = new DisplayUnit();
    @Override
    public void buildProcessor() {
        displayUnit.setProcessor(new ATMega32());
    }

    @Override
    public void buildDisplay() {
        displayUnit.setDisplay(new LED());
    }

    @Override
    public DisplayUnit getDisplayUnit() {
        return displayUnit;
    }
}
