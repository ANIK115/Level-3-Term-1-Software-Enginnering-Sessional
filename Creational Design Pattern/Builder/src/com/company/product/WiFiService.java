package com.company.product;

public class WiFiService implements CommunicationBuilder{
    private CommunicationModule module;

    @Override
    public void buildCommunication() {
        module = new CommunicationModule("WiFi Service");
        monthlyCost();
        connectionCost();
    }

    @Override
    public CommunicationModule getCommunicationModule() {
        return module;
    }

    @Override
    public void monthlyCost() {
        this.module.setMonthlyCost(3500);
    }

    @Override
    public void connectionCost() {
        this.module.setConnectionCost(2000);
    }

}
