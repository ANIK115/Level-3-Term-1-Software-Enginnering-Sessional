package com.company.meal;

public class VeggiBurger implements Meal{
    @Override
    public String prepareMeal() {
        return "Veggi Burger ";
    }

    @Override
    public double mealPrice() {
        return 100.0;
    }
}
