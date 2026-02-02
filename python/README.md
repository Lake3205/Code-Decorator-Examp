# Python Decorator Pattern Examples

This directory contains Python implementations of the Decorator Pattern with two complete examples.

## 🚀 Quick Start

### Interactive Web GUI

The best way to explore these examples is through the interactive web interface:

```bash
# From the root directory
pip install -r requirements.txt
python app.py
```

Then visit `http://localhost:5000` in your browser!

### Command Line

You can also run the examples directly:

```bash
# Coffee Shop Example
python coffee_shop.py

# Text Formatter Example
python text_formatter.py
```

## ☕ Coffee Shop Example

Demonstrates the Decorator Pattern using a coffee ordering system.

### Components

1. **Coffee (Interface)**: Abstract base class for all coffee objects
2. **SimpleCoffee (Concrete Component)**: Basic coffee implementation
3. **CoffeeDecorator (Decorator)**: Base class for all decorators
4. **Concrete Decorators**: Milk, Sugar, WhippedCream, Vanilla, Caramel

### Key Features

- Dynamic composition of coffee orders
- Multiple decorators can be stacked
- Same decorator can be applied multiple times (e.g., double sugar)
- Cost accumulates with each decorator
- Description builds dynamically

## 📝 Text Formatter Example

Demonstrates the Decorator Pattern using a text formatting system.

### Components

1. **Text (Interface)**: Base interface for all text objects
2. **PlainText (Concrete Component)**: Basic text implementation
3. **TextDecorator (Decorator)**: Base class for all decorators
4. **Concrete Decorators**:
   - **BoldDecorator**: Wraps text with HTML `<b>` tags
   - **ItalicDecorator**: Wraps text with HTML `<i>` tags
   - **UnderlineDecorator**: Wraps text with HTML `<u>` tags
   - **UpperCaseDecorator**: Converts text to uppercase
   - **EncryptDecorator**: Applies Caesar cipher encryption

### Key Features

- Order of decorators matters (encrypt then uppercase vs uppercase then encrypt)
- HTML formatting decorators can be nested
- Encryption with configurable shift value
- Processing cost increases with each decorator

## 🎨 Design Benefits

- ✅ No class explosion - no need for every combination
- ✅ Easy to add new decorators without modifying existing code
- ✅ Flexible composition at runtime
- ✅ Single Responsibility: Each decorator handles one transformation
- ✅ Open/Closed Principle: Open for extension, closed for modification
