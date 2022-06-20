package com.company.factory;

import com.company.decorators.CheeseDecorator;
import com.company.decorators.MealDecorator;
import com.company.meal.Meal;

public class CheeseFactory extends AbstractMealFactory{
    @Override
    public Meal getBurger(String burgerType) {
        return null;
    }

    @Override
    public Meal addCheese(Meal meal) {
        return new CheeseDecorator(meal);
    }

    @Override
    public Meal addAppetizer(String appetizer, Meal meal) {
        return null;
    }

    @Override
    public Meal addDrinks(String drinks, Meal meal) {
        return null;
    }
}
