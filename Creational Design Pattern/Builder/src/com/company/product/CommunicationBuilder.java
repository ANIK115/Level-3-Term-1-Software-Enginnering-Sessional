package com.company.product;

public interface CommunicationBuilder {
    void buildCommunication(String moduleName, int price);
    CommunicationModule getCommunicationModule();
}
