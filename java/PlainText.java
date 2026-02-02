/**
 * Concrete Component
 * The basic object to which additional responsibilities can be added.
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
        return 1.0;  // Base cost for plain text
    }
}
