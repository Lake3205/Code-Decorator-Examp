/**
 * Component Interface
 * Defines the interface for objects that can have responsibilities added to them.
 */
public interface Text {
    /**
     * Returns the content of the text
     */
    String getContent();
    
    /**
     * Returns the processing cost (arbitrary units)
     */
    double getCost();
}
