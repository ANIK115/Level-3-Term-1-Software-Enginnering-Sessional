package com.company.decorators;

import com.company.meal.Meal;

public class OnionRingsDecorator extends MealDecorator{
    public OnionRingsDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String prepareMeal() {
        return super.prepareMeal()+"with Onion Rings ";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice()+120.0;
    }
}
