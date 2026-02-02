/**
 * Concrete Decorator: UpperCaseDecorator
 * Converts text to uppercase
 */
public class UpperCaseDecorator extends TextDecorator {
    
    public UpperCaseDecorator(Text text) {
        super(text);
    }
    
    @Override
    public String getContent() {
        return decoratedText.getContent().toUpperCase();
    }
    
    @Override
    public double getCost() {
        return decoratedText.getCost() + 0.5;  // Additional cost for uppercase processing
    }
}
