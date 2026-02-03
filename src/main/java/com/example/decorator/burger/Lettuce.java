package com.example.decorator.burger;

public class Lettuce extends BurgerDecorator {
    public Lettuce(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Lettuce";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 0.30;
    }

    @Override
    public String getSentencePart() {
        String prev = burger.getSentencePart();
        return prev.isEmpty() ? "a leaf of lettuce" : prev + ", a leaf of lettuce";
    }
}
