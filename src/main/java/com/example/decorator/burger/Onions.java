package com.example.decorator.burger;

public class Onions extends BurgerDecorator {
    public Onions(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Onions";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 0.35;
    }
}
