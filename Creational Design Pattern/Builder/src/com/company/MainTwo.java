package com.company;

import com.company.builder.QueueMSBuilder;
import com.company.builder.QueueManagementSystem;
import com.company.product.BuildDisplayUnit;
import com.company.product.CommunicationBuilder;
import com.company.product.Deluxe;
import com.company.product.WiFiService;

public class MainTwo {

    public static void main(String[] args) {
	// write your code here
        BuildDisplayUnit buildDisplayUnit = new Deluxe();
        CommunicationBuilder communicationBuilder = new WiFiService();
        QueueMSBuilder builder = new QueueMSBuilder();
        builder.QMSFactory("Optimal", "WiFi", 4);
        QueueManagementSystem system = builder.getQms();
        system.showDescription();
    }
}
