package com.example.decorator.text;

/**
 * Base Decorator class that wraps a Text object
 */
public abstract class TextDecorator implements Text {
    protected Text text;

    public TextDecorator(Text text) {
        this.text = text;
    }

    @Override
    public abstract String getContent();

    @Override
    public abstract double getCost();
}
