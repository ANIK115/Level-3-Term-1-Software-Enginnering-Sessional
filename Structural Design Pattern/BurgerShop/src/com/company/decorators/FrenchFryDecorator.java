package com.company.decorators;

import com.company.meal.Meal;

public class FrenchFryDecorator extends MealDecorator{
    public FrenchFryDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String prepareMeal() {
        return super.prepareMeal()+"with French Fry ";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice()+100.0;
    }
}
