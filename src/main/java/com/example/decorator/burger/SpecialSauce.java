package com.example.decorator.burger;

public class SpecialSauce extends BurgerDecorator {
    public SpecialSauce(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Special Sauce";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 0.50;
    }

    @Override
    public String getSentencePart() {
        String prev = burger.getSentencePart();
        return prev.isEmpty() ? "special sauce" : prev + ", special sauce";
    }
}
