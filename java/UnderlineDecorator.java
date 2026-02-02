/**
 * Concrete Decorator: UnderlineDecorator
 * Wraps text with HTML underline tags
 */
public class UnderlineDecorator extends TextDecorator {
    
    public UnderlineDecorator(Text text) {
        super(text);
    }
    
    @Override
    public String getContent() {
        return "<u>" + decoratedText.getContent() + "</u>";
    }
    
    @Override
    public double getCost() {
        return decoratedText.getCost() + 0.2;  // Additional cost for underline formatting
    }
}
