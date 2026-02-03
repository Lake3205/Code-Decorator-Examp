package com.example.decorator.text;

public class EncryptDecorator extends TextDecorator {
    private int shift;

    public EncryptDecorator(Text text, int shift) {
        super(text);
        this.shift = shift;
    }

    @Override
    public String getContent() {
        String original = text.getContent();
        StringBuilder encrypted = new StringBuilder();

        for (char c : original.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char encryptedChar = (char) ((c - base + shift) % 26 + base);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    @Override
    public double getCost() {
        return text.getCost() + 1.5;
    }
}
