package com.company.product;

public class MobileService implements CommunicationBuilder {
    private CommunicationModule module;

    @Override
    public void buildCommunication() {
        module = new CommunicationModule("Mobile Service");
    }

    @Override
    public CommunicationModule getCommunicationModule() {
        return module;
    }

    @Override
    public void monthlyCost() {
        this.module.setMonthlyCost(2000);
    }

    @Override
    public void connectionCost() {
        this.module.setConnectionCost(500);
    }

}
