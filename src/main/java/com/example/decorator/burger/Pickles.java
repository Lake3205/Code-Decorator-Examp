package com.example.decorator.burger;

public class Pickles extends BurgerDecorator {
    public Pickles(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Pickles";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 0.25;
    }
}
