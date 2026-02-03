# Coffee Shop Decorator Example

## Overview

This example demonstrates the Decorator Pattern by building customizable coffee orders. You start with a simple coffee and dynamically add ingredients (decorators) to create complex beverages with calculated costs and descriptions.

## Structure

### Base Interface
```java
public interface Coffee {
    String getDescription();
    double getCost();
}
```

The `Coffee` interface defines the contract that both the base coffee and all decorators must follow.

### Concrete Component
```java
public class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }
    
    public double getCost() {
        return 2.00;
    }
}
```

`SimpleCoffee` is the base object - a plain coffee that costs $2.00.

### Abstract Decorator
```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;  // Wrapped coffee object
    
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
```

`CoffeeDecorator` holds a reference to a `Coffee` object (which could be SimpleCoffee or another decorator).

### Concrete Decorators

**Milk Decorator** - Adds $0.50
```java
public class Milk extends CoffeeDecorator {
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
    
    public double getCost() {
        return coffee.getCost() + 0.50;
    }
}
```

**Sugar Decorator** - Adds $0.20
```java
public class Sugar extends CoffeeDecorator {
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }
    
    public double getCost() {
        return coffee.getCost() + 0.20;
    }
}
```

**Other Decorators:**
- `Vanilla` - Adds $0.75
- `Caramel` - Adds $0.60
- `WhippedCream` - Adds $0.70

## How It Works

### Step-by-Step Example

```java
// 1. Start with base coffee
Coffee myCoffee = new SimpleCoffee();
// Description: "Simple Coffee"
// Cost: $2.00

// 2. Add milk
myCoffee = new Milk(myCoffee);
// Description: "Simple Coffee, Milk"
// Cost: $2.50 ($2.00 + $0.50)

// 3. Add sugar
myCoffee = new Sugar(myCoffee);
// Description: "Simple Coffee, Milk, Sugar"
// Cost: $2.70 ($2.50 + $0.20)

// 4. Add vanilla
myCoffee = new Vanilla(myCoffee);
// Description: "Simple Coffee, Milk, Sugar, Vanilla"
// Cost: $3.45 ($2.70 + $0.75)
```

### The Chain of Calls

When you call `myCoffee.getCost()` on the final decorated object:

```
Vanilla.getCost() 
  → calls Sugar.getCost() + 0.75
    → calls Milk.getCost() + 0.20
      → calls SimpleCoffee.getCost() + 0.50
        → returns 2.00
```

The result propagates back up: `2.00 + 0.50 + 0.20 + 0.75 = $3.45`

## Order Independence

In this coffee example, **order doesn't affect the final cost**:

```java
// Option 1
new Sugar(new Milk(new SimpleCoffee()))
// Cost: $2.70, Description: "Simple Coffee, Milk, Sugar"

// Option 2
new Milk(new Sugar(new SimpleCoffee()))
// Cost: $2.70, Description: "Simple Coffee, Sugar, Milk"
```

Both produce the same total cost because:
- Addition is commutative: `2.00 + 0.50 + 0.20 = 2.00 + 0.20 + 0.50`
- Each decorator independently adds its cost without affecting others

The only difference is the description text order, which may or may not matter for your use case.

## Benefits in This Example

1. **Extensibility**: Easy to add new ingredients without modifying existing code
2. **Flexibility**: Customers can create any combination of ingredients
3. **No Class Explosion**: Instead of creating classes like `CoffeeWithMilk`, `CoffeeWithMilkAndSugar`, `CoffeeWithMilkSugarAndVanilla`, etc., you compose decorators
4. **Runtime Composition**: Ingredient combinations are determined at runtime based on customer orders

## Real-World Usage

```java
// Customer order: Large caramel vanilla latte
Coffee order = new SimpleCoffee();
order = new Milk(order);
order = new Milk(order);  // Extra milk for latte
order = new Vanilla(order);
order = new Caramel(order);
order = new WhippedCream(order);

System.out.println(order.getDescription());
System.out.println("Total: $" + order.getCost());
```

This pattern mirrors how coffee shops actually work - start with base coffee and add customizations per customer request!
