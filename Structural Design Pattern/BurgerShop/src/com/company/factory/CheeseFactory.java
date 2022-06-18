package com.company.factory;

import com.company.decorators.CheeseDecorator;
import com.company.decorators.MealDecorator;

public class CheeseFactory extends AbstractMealFactory{
    @Override
    public MealDecorator getBurger(String burgerType) {
        return null;
    }

    @Override
    public MealDecorator addCheese(MealDecorator meal) {
        return new CheeseDecorator(meal);
    }

    @Override
    public MealDecorator addAppetizer(String appetizer, MealDecorator meal) {
        return null;
    }

    @Override
    public MealDecorator addDrinks(String drinks, MealDecorator meal) {
        return null;
    }
}
