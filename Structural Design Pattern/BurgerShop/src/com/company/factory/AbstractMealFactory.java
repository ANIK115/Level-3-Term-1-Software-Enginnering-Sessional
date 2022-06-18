package com.company.factory;

import com.company.decorators.MealDecorator;
import com.company.meal.Meal;

public abstract class AbstractMealFactory {
    public abstract MealDecorator getBurger(String burgerType);
    public abstract MealDecorator addCheese(MealDecorator meal);
    public abstract MealDecorator addAppetizer(String appetizer, MealDecorator meal);
    public abstract MealDecorator addDrinks(String drinks, MealDecorator meal);

}
