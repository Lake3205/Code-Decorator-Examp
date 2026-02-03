package com.example.decorator.burger;

public abstract class BurgerDecorator implements Burger {
    protected Burger burger;

    public BurgerDecorator(Burger burger) {
        this.burger = burger;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getCost();
}
