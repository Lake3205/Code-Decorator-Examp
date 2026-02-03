package com.example.decorator.burger;

public class Patty extends BurgerDecorator {
    public Patty(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Patty";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 2.50;
    }
}
