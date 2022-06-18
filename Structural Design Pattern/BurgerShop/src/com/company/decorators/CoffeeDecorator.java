package com.company.decorators;

import com.company.meal.Meal;

public class CoffeeDecorator extends MealDecorator{
    public CoffeeDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String prepareMeal() {
        return super.prepareMeal()+"with Coffee ";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice()+70.0;
    }
}
