package com.example.decorator.text;

/**
 * Concrete Component - Basic text without any formatting
 */
public class PlainText implements Text {
    private String content;

    public PlainText(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public double getCost() {
        return 1.0;
    }
}
