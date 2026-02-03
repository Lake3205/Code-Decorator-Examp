package com.example.decorator.coffee;

/**
 * Concrete Decorator - Adds whipped cream to the coffee
 */
public class WhippedCream extends CoffeeDecorator {
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.70;
    }
}
