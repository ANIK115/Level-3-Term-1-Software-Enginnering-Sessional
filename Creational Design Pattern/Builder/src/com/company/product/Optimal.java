package com.company.product;

public class Optimal implements BuildDisplayUnit{
    DisplayUnit displayUnit = new DisplayUnit();

    @Override
    public void buildProcessor() {
        displayUnit.processor = new ArduinoMega();
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
