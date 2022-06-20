package com.company.factory;

import com.company.decorators.CoffeeDecorator;
import com.company.decorators.CokeDecorator;
import com.company.decorators.MealDecorator;
import com.company.decorators.WaterDecorator;
import com.company.meal.Meal;

public class DrinksFactory extends AbstractMealFactory{
    @Override
    public Meal getBurger(String burgerType) {
        return null;
    }

    @Override
    public Meal addCheese(Meal meal) {
        return null;
    }

    @Override
    public Meal addAppetizer(String appetizer, Meal meal) {
        return null;
    }

    @Override
    public Meal addDrinks(String drinks, Meal meal) {
        if(drinks.equalsIgnoreCase("water"))
        {
            return new WaterDecorator(meal);
        }else if(drinks.equalsIgnoreCase("coke"))
        {
            return new CokeDecorator(meal);
        }else if(drinks.equalsIgnoreCase("coffee"))
        {
            return new CoffeeDecorator(meal);
        }else
        {
            return null;
        }
    }
}
