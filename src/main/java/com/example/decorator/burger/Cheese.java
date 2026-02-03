package com.example.decorator.burger;

public class Cheese extends BurgerDecorator {
    public Cheese(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 0.75;
    }
}
