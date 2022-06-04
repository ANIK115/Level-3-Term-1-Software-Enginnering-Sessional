package com.company.builder;

import com.company.product.BuildDisplayUnit;
import com.company.product.CommunicationBuilder;

public class QueueMSBuilder {
    private BuildDisplayUnit displayBuilder;
    private CommunicationBuilder communicationBuilder;

    QueueManagementSystem qms = new QueueManagementSystem();

    public void constructQMS(BuildDisplayUnit bdu, CommunicationBuilder cb, int noOfDisplayUnits, String control, int controlPrice, String moduleName, int modulePrice)
    {
        displayBuilder = bdu;
        communicationBuilder = cb;
        bdu.buildProcessor();
        bdu.buildDisplay();
        qms.setDisplayUnit(displayBuilder.getDisplayUnit());
        communicationBuilder.buildCommunication(moduleName, modulePrice);
        qms.setModule(communicationBuilder.getCommunicationModule());
        qms.setNoOfDisplayUnits(noOfDisplayUnits);
        qms.setControlDisplayName(control);
        qms.setControlDisplayPrice(controlPrice);

    }

    public QueueManagementSystem getQms()
    {
        return qms;
    }

}
