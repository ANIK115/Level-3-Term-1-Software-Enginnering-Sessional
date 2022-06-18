package com.company.factory;

import com.company.decorators.CokeDecorator;
import com.company.decorators.MealDecorator;
import com.company.decorators.WaterDecorator;

public class DrinksFactory extends AbstractMealFactory{
    @Override
    public MealDecorator getBurger(String burgerType) {
        return null;
    }

    @Override
    public MealDecorator addCheese(MealDecorator meal) {
        return null;
    }

    @Override
    public MealDecorator addAppetizer(String appetizer, MealDecorator meal) {
        return null;
    }

    @Override
    public MealDecorator addDrinks(String drinks, MealDecorator meal) {
        if(drinks.equalsIgnoreCase("water"))
        {
            return new WaterDecorator(meal);
        }else if(drinks.equalsIgnoreCase("coke"))
        {
            return new CokeDecorator(meal);
        }else if(drinks.equalsIgnoreCase("coffee"))
        {
            return new CokeDecorator(meal);
        }else
        {
            return null;
        }
    }
}
