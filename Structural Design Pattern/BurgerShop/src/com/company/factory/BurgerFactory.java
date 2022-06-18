package com.company.factory;

import com.company.decorators.MealDecorator;
import com.company.meal.BeefBurger;
import com.company.meal.ChickenBurger;
import com.company.meal.Meal;
import com.company.meal.VeggiBurger;

public class BurgerFactory extends AbstractMealFactory{
    @Override
    public MealDecorator getBurger(String burgerType) {
        if (burgerType.equalsIgnoreCase("beef"))
        {
            return new MealDecorator(new BeefBurger());
        }else if(burgerType.equalsIgnoreCase("chicken"))
        {
            return new MealDecorator(new ChickenBurger());
        }else
        {
            return new MealDecorator(new VeggiBurger());
        }
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
        return null;
    }
}
