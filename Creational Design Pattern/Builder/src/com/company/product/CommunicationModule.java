package com.company.product;

public class CommunicationModule {
    private String name;
    private int monthlyCost;
    private int connectionCost;

    public CommunicationModule(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(int monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public int getConnectionCost() {
        return connectionCost;
    }

    public void setConnectionCost(int connectionCost) {
        this.connectionCost = connectionCost;
    }
}
