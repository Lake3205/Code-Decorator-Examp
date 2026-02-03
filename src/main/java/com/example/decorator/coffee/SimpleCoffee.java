package com.example.decorator.coffee;

/**
 * Concrete Component - Basic coffee without any additions
 */
public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.00;
    }
}
