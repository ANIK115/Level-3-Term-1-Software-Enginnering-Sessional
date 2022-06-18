package com.company.decorators;

import com.company.meal.Meal;

public class MealDecorator implements Meal{
    protected Meal meal;

    public MealDecorator(Meal meal) {
        this.meal = meal;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @Override
    public String prepareMeal() {
        return meal.prepareMeal();
    }

    @Override
    public double mealPrice() {
        return meal.mealPrice();
    }
}
