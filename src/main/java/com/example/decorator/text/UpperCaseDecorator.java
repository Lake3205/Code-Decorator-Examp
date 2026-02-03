package com.example.decorator.text;

/**
 * Concrete Decorator - Converts text to uppercase
 */
public class UpperCaseDecorator extends TextDecorator {
    public UpperCaseDecorator(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return text.getContent().toUpperCase();
    }

    @Override
    public double getCost() {
        return text.getCost() + 0.5;
    }
}
