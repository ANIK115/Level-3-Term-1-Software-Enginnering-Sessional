package com.company.decorators;

import com.company.meal.Meal;

public class CokeDecorator extends MealDecorator{
    public CokeDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String prepareMeal() {
        return super.prepareMeal()+"with Coke ";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice()+35.0;
    }
}
