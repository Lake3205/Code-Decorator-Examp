# Java Decorator Pattern Example

## Text Formatter Implementation

This example demonstrates the Decorator Pattern using a text formatting system.

### Components

1. **Text (Interface)**: Base interface for all text objects
2. **PlainText (Concrete Component)**: Basic text implementation
3. **TextDecorator (Decorator)**: Abstract base class for all decorators
4. **Concrete Decorators**:
   - UpperCaseDecorator: Converts text to uppercase
   - BoldDecorator: Wraps text with `<b>` tags
   - ItalicDecorator: Wraps text with `<i>` tags
   - UnderlineDecorator: Wraps text with `<u>` tags
   - EncryptDecorator: Applies Caesar cipher encryption

### How to Run

```bash
# Compile all Java files
javac *.java

# Run the main program
java Main
```

### Expected Output

The program demonstrates various text transformations with different combinations of decorators:
- Plain text ($1.00)
- Uppercase text ($1.50)
- Bold text ($1.30)
- Bold and italic text ($1.60)
- Multiple formatting combinations
- Encrypted text ($2.50)
- Order-dependent transformations

### Key Concepts Demonstrated

1. **Dynamic Composition**: Decorators added at runtime
2. **Multiple Decorators**: Stack various formatters on the same text
3. **Order Matters**: Different order = different results (encrypt then uppercase vs uppercase then encrypt)
4. **Cost Accumulation**: Each decorator adds processing cost
5. **Transparency**: Decorators and components share the same interface

### Design Benefits

- ✅ No explosion of subclasses (BoldItalicText, BoldUnderlineText, etc.)
- ✅ Easy to add new formatters (ColorDecorator, SizeDecorator) without modifying existing code
- ✅ Flexible composition at runtime
- ✅ Single Responsibility: Each decorator handles one transformation
- ✅ Open/Closed Principle: Open for extension, closed for modification

### Real-World Applications

This pattern is similar to:
- Java I/O streams (BufferedInputStream, DataInputStream wrapping FileInputStream)
- UI component decorators (adding borders, scrollbars to windows)
- Middleware in web frameworks
