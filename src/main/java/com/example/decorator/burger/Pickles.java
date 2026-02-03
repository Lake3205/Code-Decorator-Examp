package com.example.decorator.burger;

public class Pickles extends BurgerDecorator {
    public Pickles(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Pickles";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 0.25;
    }

    @Override
    public String getSentencePart() {
        String prev = burger.getSentencePart();
        return prev.isEmpty() ? "some pickles" : prev + ", some pickles";
    }
}
