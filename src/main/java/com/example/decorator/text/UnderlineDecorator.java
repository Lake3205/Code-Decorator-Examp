package com.example.decorator.text;

/**
 * Concrete Decorator - Wraps text with HTML underline tags
 */
public class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return "<u>" + text.getContent() + "</u>";
    }

    @Override
    public double getCost() {
        return text.getCost() + 0.2;
    }
}
