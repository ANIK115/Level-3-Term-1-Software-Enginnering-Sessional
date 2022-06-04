package com.company.builder;

import com.company.product.BuildDisplayUnit;
import com.company.product.CommunicationModule;
import com.company.product.DisplayUnit;

public class QueueManagementSystem {
    private int noOfDisplayUnits;
    private int controlDisplayPrice;
    private DisplayUnit displayUnit;
    private CommunicationModule module;
    private String controlDisplayName;

    public QueueManagementSystem() {
    }

    public int getYearlyCommunicationPrice() {
        return (module.getCost()*12);
    }

    public int getNoOfDisplayUnits() {
        return noOfDisplayUnits;
    }

    public void setNoOfDisplayUnits(int noOfDisplayUnits) {
        this.noOfDisplayUnits = noOfDisplayUnits;
    }

    public int getControlDisplayPrice() {
        return controlDisplayPrice;
    }

    public void setControlDisplayPrice(int controlDisplayPrice) {
        this.controlDisplayPrice = controlDisplayPrice;
    }

    public DisplayUnit getDisplayUnit() {
        return displayUnit;
    }

    public void setDisplayUnit(DisplayUnit displayUnit) {
        this.displayUnit = displayUnit;
    }

    public CommunicationModule getModule() {
        return module;
    }

    public void setModule(CommunicationModule module) {
        this.module = module;
    }

    public String getControlDisplayName() {
        return controlDisplayName;
    }

    public void setControlDisplayName(String controlDisplayName) {
        this.controlDisplayName = controlDisplayName;
    }
}
