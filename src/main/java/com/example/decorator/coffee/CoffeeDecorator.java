package com.example.decorator.coffee;

/**
 * Base Decorator class that wraps a Coffee object
 */
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getCost();
}
