package com.company.product;

public class Optimal implements BuildDisplayUnit{
    DisplayUnit displayUnit = new DisplayUnit();

    @Override
    public void buildProcessor() {
        displayUnit.setProcessor(new ArduinoMega());
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
