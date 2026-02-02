/**
 * Concrete Decorator: BoldDecorator
 * Wraps text with HTML bold tags
 */
public class BoldDecorator extends TextDecorator {
    
    public BoldDecorator(Text text) {
        super(text);
    }
    
    @Override
    public String getContent() {
        return "<b>" + decoratedText.getContent() + "</b>";
    }
    
    @Override
    public double getCost() {
        return decoratedText.getCost() + 0.3;  // Additional cost for bold formatting
    }
}
