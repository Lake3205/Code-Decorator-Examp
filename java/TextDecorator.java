/**
 * Decorator Base Class
 * Maintains a reference to a Text object and implements the Text interface.
 */
public abstract class TextDecorator implements Text {
    protected Text decoratedText;
    
    public TextDecorator(Text text) {
        this.decoratedText = text;
    }
    
    @Override
    public String getContent() {
        return decoratedText.getContent();
    }
    
    @Override
    public double getCost() {
        return decoratedText.getCost();
    }
}
