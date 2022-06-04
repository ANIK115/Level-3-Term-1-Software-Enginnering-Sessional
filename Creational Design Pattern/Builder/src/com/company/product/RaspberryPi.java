package com.company.product;

public class RaspberryPi implements Processor{
    @Override
    public String getProcessorName() {
        return "Raspberry Pi";
    }

    @Override
    public int getProcessorCost() {
        return 100;
    }
}
