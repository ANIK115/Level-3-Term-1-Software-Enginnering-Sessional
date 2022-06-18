package com.company.meal;

public class BeefBurger implements Meal{
    @Override
    public String prepareMeal() {
        return "Beef Burger ";
    }

    @Override
    public double mealPrice() {
        return 200.0;
    }
}
