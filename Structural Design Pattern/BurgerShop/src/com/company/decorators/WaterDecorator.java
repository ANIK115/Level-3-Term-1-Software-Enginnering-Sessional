package com.company.decorators;

import com.company.meal.Meal;

public class WaterDecorator extends MealDecorator{
    public WaterDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String prepareMeal() {
        return super.prepareMeal()+"with Water ";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice()+20.0;
    }
}
