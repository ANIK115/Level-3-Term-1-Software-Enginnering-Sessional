package com.company.factory;

import com.company.decorators.FrenchFryDecorator;
import com.company.decorators.MealDecorator;
import com.company.decorators.OnionRingsDecorator;
import com.company.meal.Meal;

public class AppetizerFactory extends AbstractMealFactory{
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
        if(appetizer.equalsIgnoreCase("french fry"))
        {
            return new FrenchFryDecorator(meal);
        }else if(appetizer.equalsIgnoreCase("onion rings"))
        {
            return new OnionRingsDecorator(meal);
        }else
        {
            return null;
        }

    }

    @Override
    public Meal addDrinks(String drinks, Meal meal) {
        return null;
    }
}
