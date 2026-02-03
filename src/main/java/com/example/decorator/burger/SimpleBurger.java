package com.example.decorator.burger;

public class SimpleBurger implements Burger {
    @Override
    public String getDescription() {
        return "Simple Burger";
    }

    @Override
    public double getCost() {
        return 5.00;
    }

    @Override
    public String getSentencePart() {
        return "";
    }
}
