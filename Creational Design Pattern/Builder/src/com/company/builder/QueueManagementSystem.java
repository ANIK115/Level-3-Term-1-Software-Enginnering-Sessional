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

    public void showDescription()
    {
        System.out.println("Display Unit: ");
        System.out.println("Processor: "+displayUnit.getProcessor().getProcessorName()+" , price: "
        +displayUnit.getProcessor().getProcessorCost());
        System.out.println("Display: "+displayUnit.getDisplay().getDisplayName()+" , price: "
        +displayUnit.getDisplay().getDisplayCost());
        System.out.println("\nCommunication Channel: "+module.getName());
        System.out.println("Module cost: "+module.getConnectionCost());
        System.out.println("Control Unit: "+controlDisplayName +", Control Unit price: "+controlDisplayPrice);
        System.out.println("Number of display units: "+noOfDisplayUnits);
        System.out.println("Yearly Communication cost: "+getYearlyCommunicationPrice());
        System.out.println("Total cost of this system: "+(displayUnit.getDisplay().getDisplayCost()*noOfDisplayUnits+displayUnit.getProcessor().getProcessorCost()+module.getConnectionCost()+controlDisplayPrice+getYearlyCommunicationPrice()));

    }

    public int getYearlyCommunicationPrice() {
        return (module.getMonthlyCost()*12);
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
