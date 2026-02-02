/**
 * Main class demonstrating the Decorator Pattern
 * Text Formatter Example
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("DECORATOR PATTERN: TEXT FORMATTER EXAMPLE");
        System.out.println("=".repeat(60));
        System.out.println();
        
        // Example 1: Plain text
        System.out.println("Example 1: Plain Text");
        Text text1 = new PlainText("Hello, World!");
        printText(text1);
        System.out.println();
        
        // Example 2: Uppercase text
        System.out.println("Example 2: Uppercase Text");
        Text text2 = new PlainText("Hello, World!");
        text2 = new UpperCaseDecorator(text2);
        printText(text2);
        System.out.println();
        
        // Example 3: Bold text
        System.out.println("Example 3: Bold Text");
        Text text3 = new PlainText("Hello, World!");
        text3 = new BoldDecorator(text3);
        printText(text3);
        System.out.println();
        
        // Example 4: Bold and Italic text
        System.out.println("Example 4: Bold and Italic Text");
        Text text4 = new PlainText("Hello, World!");
        text4 = new BoldDecorator(text4);
        text4 = new ItalicDecorator(text4);
        printText(text4);
        System.out.println();
        
        // Example 5: Bold, Italic, and Underline
        System.out.println("Example 5: Bold, Italic, and Underlined Text");
        Text text5 = new PlainText("Important Message");
        text5 = new BoldDecorator(text5);
        text5 = new ItalicDecorator(text5);
        text5 = new UnderlineDecorator(text5);
        printText(text5);
        System.out.println();
        
        // Example 6: Uppercase and Bold
        System.out.println("Example 6: Uppercase and Bold Text");
        Text text6 = new PlainText("attention");
        text6 = new UpperCaseDecorator(text6);
        text6 = new BoldDecorator(text6);
        printText(text6);
        System.out.println();
        
        // Example 7: Encrypted text
        System.out.println("Example 7: Encrypted Text (Caesar Cipher, shift=3)");
        Text text7 = new PlainText("Secret Message");
        text7 = new EncryptDecorator(text7, 3);
        printText(text7);
        System.out.println();
        
        // Example 8: Multiple decorators in different order
        System.out.println("Example 8: Encrypted, then Uppercase, then Bold");
        Text text8 = new PlainText("Confidential");
        text8 = new EncryptDecorator(text8, 5);
        text8 = new UpperCaseDecorator(text8);
        text8 = new BoldDecorator(text8);
        printText(text8);
        System.out.println();
        
        System.out.println("Benefits of Decorator Pattern Demonstrated:");
        System.out.println("✓ Each decorator adds one specific responsibility");
        System.out.println("✓ Decorators can be combined in any order");
        System.out.println("✓ The order of decorators affects the final result");
        System.out.println("✓ No modification needed to the base Text class");
        System.out.println("✓ Easy to add new decorators without changing existing code");
        System.out.println("✓ Cost accumulates as decorators are added");
    }
    
    private static void printText(Text text) {
        System.out.println("Content: " + text.getContent());
        System.out.println("Cost: $" + String.format("%.2f", text.getCost()));
        System.out.println("-".repeat(60));
    }
}
