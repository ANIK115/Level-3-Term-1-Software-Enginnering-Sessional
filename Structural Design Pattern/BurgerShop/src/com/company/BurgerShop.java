package com.company;

import com.company.decorators.MealDecorator;
import com.company.factory.*;

import java.util.Scanner;

public class BurgerShop {
    MealDecorator meal = null;
    public void menu()
    {
        System.out.println("1. Beef burger with French fry and cheese\n" +
                "2. Veggi Burger with onion rings and Bottle of Water\n" +
                "3. A combo meal with Veggi burger, French Fry and Coke\n" +
                "4. A combo meal with Veggi burger, Onion Rings, Coffee and Water\n" +
                "5. A Beef burger only");
    }

    public void takeOrder()
    {
        AbstractMealFactory burgerFactory = new BurgerFactory();
        AbstractMealFactory cheeseFactory = new CheeseFactory();
        AbstractMealFactory appetizerFactory = new AppetizerFactory();
        AbstractMealFactory drinksFactory = new DrinksFactory();
        System.out.println("\n\nEnter an option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        if(option == 1)
        {
            meal = burgerFactory.getBurger("beef");
            meal = cheeseFactory.addCheese(meal);
            meal = appetizerFactory.addAppetizer("french fry", meal);
        }else if(option == 2)
        {
            meal = burgerFactory.getBurger("veggi");
            meal = appetizerFactory.addAppetizer("onion rings", meal);
            System.out.println("How many bottles of water? ");
            int quantity = scanner.nextInt();
            for (int i=0; i<quantity; i++){
                meal = drinksFactory.addDrinks("water", meal);
            }
        }else if(option == 3)
        {
            meal = burgerFactory.getBurger("veggi");
            meal = appetizerFactory.addAppetizer("french fry", meal);
            System.out.println("How many cokes? ");
            int quantity = scanner.nextInt();
            for (int i=0; i<quantity; i++){
                meal = drinksFactory.addDrinks("coke", meal);
            }
        }else if(option == 4)
        {
            meal = burgerFactory.getBurger("veggi");
            meal = appetizerFactory.addAppetizer("onion rings", meal);
            System.out.println("How many coffees? ");
            int n = scanner.nextInt();
            System.out.println("How many bottles of water?");
            int m = scanner.nextInt();
            for(int i=0; i<n; i++)
                meal = drinksFactory.addDrinks("coffee", meal);
            for(int i=0; i<m; i++)
                meal = drinksFactory.addDrinks("water",meal);
        }else if(option == 5)
        {
            meal = burgerFactory.getBurger("beef");
        }else
        {
            System.out.println("Invalid option!");
        }
    }
    public void showOrderDetails()
    {
        if(meal == null)
        {
            System.out.println("Take an order\n\n");
            return;
        }
        System.out.println(meal.prepareMeal());
        System.out.println("Total Price: "+meal.mealPrice());
        System.out.println("\n\n");
    }
}
