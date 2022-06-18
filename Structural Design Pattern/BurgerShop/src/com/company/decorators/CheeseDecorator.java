package com.company.decorators;

import com.company.meal.Meal;

public class CheeseDecorator extends MealDecorator{

    public CheeseDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String prepareMeal() {
        return super.prepareMeal()+"with cheese ";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice()+30.0;
    }
}
