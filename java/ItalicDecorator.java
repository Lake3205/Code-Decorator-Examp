/**
 * Concrete Decorator: ItalicDecorator
 * Wraps text with HTML italic tags
 */
public class ItalicDecorator extends TextDecorator {
    
    public ItalicDecorator(Text text) {
        super(text);
    }
    
    @Override
    public String getContent() {
        return "<i>" + decoratedText.getContent() + "</i>";
    }
    
    @Override
    public double getCost() {
        return decoratedText.getCost() + 0.3;  // Additional cost for italic formatting
    }
}
