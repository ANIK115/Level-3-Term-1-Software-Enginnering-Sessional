package com.company.builder;

import com.company.product.*;

public class QueueMSBuilder {
    private BuildDisplayUnit displayBuilder;
    private CommunicationBuilder communicationBuilder;
    private int noOfDisplayUnit;

    QueueManagementSystem qms = new QueueManagementSystem();

    public void QMSFactory(String displayUnit, String communication, int noOfDisplay)
    {
        this.noOfDisplayUnit = noOfDisplay;
        if(displayUnit.equalsIgnoreCase("Deluxe"))
        {
            displayBuilder = new Deluxe();
        }else if(displayUnit.equalsIgnoreCase("Optimal"))
        {
            displayBuilder = new Optimal();
        }else if(displayUnit.equalsIgnoreCase("Poor"))
        {
            displayBuilder = new Poor();
        }else
        {
            displayBuilder = new Optimal(); // default
        }

        if(communication.equalsIgnoreCase("Mobile Service"))
        {
            communicationBuilder = new MobileService();
        }else
        {
            communicationBuilder = new WiFiService(); // default
        }
        constructQMS();
    }

    public void constructQMS()
    {
        displayBuilder.buildProcessor();
        displayBuilder.buildDisplay();
        qms.setDisplayUnit(displayBuilder.getDisplayUnit());
        communicationBuilder.buildCommunication();
        qms.setModule(communicationBuilder.getCommunicationModule());
        qms.setNoOfDisplayUnits(this.noOfDisplayUnit);
        qms.setControlDisplayName("Dotcom-Monitor");
        qms.setControlDisplayPrice(21000);
    }

    public QueueManagementSystem getQms()
    {
        return qms;
    }

}
