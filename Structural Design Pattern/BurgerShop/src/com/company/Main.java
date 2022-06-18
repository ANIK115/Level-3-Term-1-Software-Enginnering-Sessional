package com.company;

public class Main {

    public static void main(String[] args) {
        BurgerShop burgerShop = new BurgerShop();
        while (true) {
            burgerShop.menu();
            burgerShop.takeOrder();
            burgerShop.showOrderDetails();
        }
	// write your code here
    }
}
