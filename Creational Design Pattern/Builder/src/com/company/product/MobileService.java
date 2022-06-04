package com.company.product;

public class MobileService implements CommunicationBuilder {
    CommunicationModule module;

    @Override
    public void buildCommunication(String moduleName, int price) {
        module = new CommunicationModule(moduleName, price);
    }

    @Override
    public CommunicationModule getCommunicationModule() {
        return module;
    }
}
