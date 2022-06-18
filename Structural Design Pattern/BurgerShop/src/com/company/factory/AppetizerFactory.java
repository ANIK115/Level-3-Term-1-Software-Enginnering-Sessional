package com.company.factory;

import com.company.decorators.FrenchFryDecorator;
import com.company.decorators.MealDecorator;
import com.company.decorators.OnionRingsDecorator;

public class AppetizerFactory extends AbstractMealFactory{
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
    public MealDecorator addDrinks(String drinks, MealDecorator meal) {
        return null;
    }
}
