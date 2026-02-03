# Decorator Pattern Example

## What is the Decorator Pattern?

The **Decorator Pattern** is a structural design pattern that allows you to dynamically add new behaviors or responsibilities to objects without modifying their code. It provides a flexible alternative to subclassing for extending functionality.

## What Problems Does It Solve?

The Decorator Pattern addresses several common design challenges:

1. **Avoiding Class Explosion**: Instead of creating multiple subclasses for every combination of features, decorators allow you to compose behaviors at runtime.

2. **Open/Closed Principle**: Classes should be open for extension but closed for modification. Decorators extend functionality without changing existing code.

3. **Single Responsibility Principle**: Each decorator handles one specific responsibility, making code more maintainable.

4. **Runtime Flexibility**: Unlike inheritance (which is static), decorators allow you to add or remove responsibilities at runtime.

### Real-World Examples:
- Adding toppings to a coffee (extra shot, milk, whipped cream)
- Adding features to a text editor (spell check, auto-save, formatting)
- Adding encryption, compression, or buffering to data streams
- Adding UI components (borders, scrollbars, shadows to windows)

## How It Works

The Decorator Pattern consists of four main components:

1. **Component Interface**: Defines the interface for objects that can have responsibilities added to them.

2. **Concrete Component**: The base object to which additional responsibilities can be added.

3. **Decorator**: An abstract class that implements the Component interface and contains a reference to a Component object.

4. **Concrete Decorators**: Extend the Decorator class and add specific responsibilities.

### Structure:
```
Component (interface)
    |
    |-- ConcreteComponent (base object)
    |
    |-- Decorator (wraps Component)
            |
            |-- ConcreteDecoratorA
            |-- ConcreteDecoratorB
```

### Key Principles:
- Decorators have the same interface as the objects they wrap
- Decorators forward requests to the wrapped object
- Decorators can add behavior before/after forwarding the request
- Multiple decorators can be stacked/nested

## Code Examples

This repository contains Java implementations with an interactive web GUI:

- **Coffee Shop Example** - Demonstrates decorators by building customized coffee orders
- **Text Formatter Example** - Shows text formatting with various decorators (bold, italic, underline, uppercase, encryption)

### 🌐 Interactive Web GUI

Experience the decorator pattern in action with our interactive web interface:

```bash
# Build the application
mvn clean package

# Run the web application
java -jar target/decorator-pattern-example-1.0.0.jar
```

Then open your browser to `http://localhost:5000` to see the interactive examples!

## Benefits

✅ **Flexibility**: Add or remove responsibilities at runtime  
✅ **Composability**: Combine multiple decorators in any order  
✅ **Maintainability**: Each decorator focuses on one responsibility  
✅ **Testability**: Easy to test individual decorators  

## Drawbacks

⚠️ **Complexity**: Can result in many small classes  
⚠️ **Debugging**: Stacked decorators can be hard to debug  
⚠️ **Order Dependency**: The order of decorators can matter  

## When to Use

Use the Decorator Pattern when:
- You need to add responsibilities to objects dynamically and transparently
- Extension by subclassing is impractical or impossible
- You want to add responsibilities that can be withdrawn
- You need different combinations of behaviors

## References

- "Design Patterns: Elements of Reusable Object-Oriented Software" by Gang of Four
- [Refactoring Guru - Decorator Pattern](https://refactoring.guru/design-patterns/decorator)
