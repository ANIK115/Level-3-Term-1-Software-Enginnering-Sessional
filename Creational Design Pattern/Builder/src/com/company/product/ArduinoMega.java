package com.company.product;

public class ArduinoMega implements Processor{
    @Override
    public String getProcessorName() {
        return "Arduino Mega";
    }

    @Override
    public int getProcessorCost() {
        return 150;
    }
}
