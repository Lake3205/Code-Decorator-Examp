# Decorator Pattern

## Overview

The **Decorator Pattern** is a structural design pattern that allows you to dynamically add new behaviors and responsibilities to objects without modifying their underlying classes. It provides a flexible alternative to subclassing for extending functionality.

## Key Concepts

### Components

1. **Component Interface**: Defines the common interface for both the base object and decorators
2. **Concrete Component**: The original object that can be decorated
3. **Decorator**: Abstract class that implements the component interface and contains a reference to a component
4. **Concrete Decorators**: Specific decorators that add new behaviors

### How It Works

Decorators wrap objects in a chain, where each decorator:
- Implements the same interface as the object it decorates
- Holds a reference to the wrapped object
- Delegates calls to the wrapped object
- Adds its own behavior before or after delegation

## Benefits

- **Open/Closed Principle**: Classes are open for extension but closed for modification
- **Single Responsibility**: Each decorator handles one specific concern
- **Dynamic Composition**: Behaviors can be combined at runtime
- **Flexibility**: Multiple decorators can be stacked in any order

## Examples in This Project

### Coffee Shop Example
```
SimpleCoffee → Milk → Sugar → Vanilla → Caramel
```
Each decorator adds ingredients and costs to the base coffee.

### Text Formatting Example
```
PlainText → BoldDecorator → ItalicDecorator → UnderlineDecorator
```
Each decorator adds formatting to the base text.

## Use Cases

- Adding responsibilities to individual objects dynamically
- When extension by subclassing is impractical
- GUI component libraries (borders, scrollbars, etc.)
- I/O streams (BufferedReader wrapping FileReader)
- Middleware in web frameworks

## Trade-offs

**Advantages:**
- More flexible than static inheritance
- Avoids feature-laden classes at the top of the hierarchy
- Responsibilities can be added/removed at runtime

**Disadvantages:**
- Can result in many small objects
- Can be complex to debug with multiple layers of decoration
- Order of decorators may matter
