package com.example.decorator.burger;

public class Bacon extends BurgerDecorator {
    public Bacon(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Bacon";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 1.50;
    }
}
