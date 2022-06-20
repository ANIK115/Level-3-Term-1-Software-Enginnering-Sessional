package com.company.factory;

import com.company.decorators.MealDecorator;
import com.company.meal.Meal;

public abstract class AbstractMealFactory {
    public abstract Meal getBurger(String burgerType);
    public abstract Meal addCheese(Meal meal);
    public abstract Meal addAppetizer(String appetizer, Meal meal);
    public abstract Meal addDrinks(String drinks, Meal meal);

}
