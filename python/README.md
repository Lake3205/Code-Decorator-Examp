# Python Decorator Pattern Example

## Coffee Shop Implementation

This example demonstrates the Decorator Pattern using a coffee ordering system.

### Components

1. **Coffee (Interface)**: Abstract base class for all coffee objects
2. **SimpleCoffee (Concrete Component)**: Basic coffee implementation
3. **CoffeeDecorator (Decorator)**: Base class for all decorators
4. **Concrete Decorators**: Milk, Sugar, WhippedCream, Vanilla, Caramel

### How to Run

```bash
python coffee_shop.py
```

### Expected Output

The program demonstrates various coffee orders with different combinations of decorators, showing:
- Basic coffee ($2.00)
- Coffee with milk ($2.50)
- Coffee with milk and sugar ($2.70)
- Deluxe coffee with multiple additions ($4.40)
- Coffee with double sugar ($2.90)

### Key Concepts Demonstrated

1. **Dynamic Composition**: Decorators can be added at runtime
2. **Multiple Decorators**: Stack multiple decorators on the same object
3. **Repeated Decorators**: Apply the same decorator multiple times
4. **Cost Calculation**: Each decorator adds its own cost
5. **Description Building**: Each decorator extends the description

### Design Benefits

- ✅ No need to create a class for every combination (Milk+Sugar, Vanilla+Caramel, etc.)
- ✅ Easy to add new decorators (e.g., Chocolate, Cinnamon) without modifying existing code
- ✅ Flexible composition at runtime
- ✅ Single Responsibility: Each decorator does one thing
