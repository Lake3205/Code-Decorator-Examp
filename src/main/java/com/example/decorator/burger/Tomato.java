package com.example.decorator.burger;

public class Tomato extends BurgerDecorator {
    public Tomato(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Tomato";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 0.40;
    }
}
