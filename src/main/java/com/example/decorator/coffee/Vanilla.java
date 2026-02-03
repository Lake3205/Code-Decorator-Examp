package com.example.decorator.coffee;

public class Vanilla extends CoffeeDecorator {
    public Vanilla(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Vanilla";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.60;
    }
}
