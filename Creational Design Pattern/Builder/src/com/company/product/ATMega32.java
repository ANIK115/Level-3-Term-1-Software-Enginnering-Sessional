package com.company.product;

public class ATMega32 implements Processor{
    @Override
    public String getProcessorName() {
        return "ATMega32";
    }

    @Override
    public int getProcessorCost() {
        return 12000;
    }
}
