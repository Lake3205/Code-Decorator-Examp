package com.example.decorator.text;

/**
 * Concrete Decorator - Wraps text with HTML italic tags
 */
public class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return "<i>" + text.getContent() + "</i>";
    }

    @Override
    public double getCost() {
        return text.getCost() + 0.3;
    }
}
