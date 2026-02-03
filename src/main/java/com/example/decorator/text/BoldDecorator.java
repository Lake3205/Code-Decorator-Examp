package com.example.decorator.text;

/**
 * Concrete Decorator - Wraps text with HTML bold tags
 */
public class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return "<b>" + text.getContent() + "</b>";
    }

    @Override
    public double getCost() {
        return text.getCost() + 0.3;
    }
}
