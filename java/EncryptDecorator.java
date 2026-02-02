/**
 * Concrete Decorator: EncryptDecorator
 * Simple encryption decorator (Caesar cipher)
 */
public class EncryptDecorator extends TextDecorator {
    private int shift;
    
    public EncryptDecorator(Text text, int shift) {
        super(text);
        this.shift = shift;
    }
    
    public EncryptDecorator(Text text) {
        this(text, 3);  // Default shift of 3
    }
    
    @Override
    public String getContent() {
        String original = decoratedText.getContent();
        StringBuilder encrypted = new StringBuilder();
        
        for (char c : original.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + shift) % 26 + base);
            }
            encrypted.append(c);
        }
        
        return encrypted.toString();
    }
    
    @Override
    public double getCost() {
        return decoratedText.getCost() + 1.5;  // Higher cost for encryption
    }
}
