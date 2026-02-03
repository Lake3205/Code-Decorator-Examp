package com.example.decorator.coffee;

/**
 * Concrete Decorator - Adds caramel flavoring to the coffee
 */
public class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Caramel";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.60;
    }
}
