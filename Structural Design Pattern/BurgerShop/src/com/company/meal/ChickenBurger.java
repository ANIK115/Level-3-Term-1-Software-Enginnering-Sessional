package com.company.meal;

public class ChickenBurger implements Meal{
    @Override
    public String prepareMeal() {
        return "Chicken Burger ";
    }

    @Override
    public double mealPrice() {
        return 160.0;
    }
}
