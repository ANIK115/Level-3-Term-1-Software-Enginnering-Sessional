package com.company.factory;

import com.company.decorators.MealDecorator;
import com.company.meal.BeefBurger;
import com.company.meal.ChickenBurger;
import com.company.meal.Meal;
import com.company.meal.VeggiBurger;

public class BurgerFactory extends AbstractMealFactory{
    @Override
    public Meal getBurger(String burgerType) {
        if (burgerType.equalsIgnoreCase("beef"))
        {
            return new BeefBurger();
        }else if(burgerType.equalsIgnoreCase("chicken"))
        {
            return new ChickenBurger();
        }else
        {
            return new VeggiBurger();
        }
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
        return null;
    }
}
