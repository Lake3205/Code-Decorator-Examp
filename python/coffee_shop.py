"""
Decorator Pattern Example: Coffee Shop
=======================================

This example demonstrates the Decorator Pattern using a coffee shop scenario.
Customers can order a base coffee and add various decorators (toppings/additions).
"""

from abc import ABC, abstractmethod


# Component Interface
class Coffee(ABC):
    """Base interface for all coffee beverages"""
    
    @abstractmethod
    def get_description(self) -> str:
        """Returns the description of the coffee"""
        pass
    
    @abstractmethod
    def get_cost(self) -> float:
        """Returns the cost of the coffee"""
        pass


# Concrete Component
class SimpleCoffee(Coffee):
    """Basic coffee without any additions"""
    
    def get_description(self) -> str:
        return "Simple Coffee"
    
    def get_cost(self) -> float:
        return 2.00


# Decorator Base Class
class CoffeeDecorator(Coffee):
    """Base decorator class that wraps a Coffee object"""
    
    def __init__(self, coffee: Coffee):
        self._coffee = coffee
    
    @abstractmethod
    def get_description(self) -> str:
        pass
    
    @abstractmethod
    def get_cost(self) -> float:
        pass


# Concrete Decorators
class Milk(CoffeeDecorator):
    """Adds milk to the coffee"""
    
    def get_description(self) -> str:
        return f"{self._coffee.get_description()}, Milk"
    
    def get_cost(self) -> float:
        return self._coffee.get_cost() + 0.50


class Sugar(CoffeeDecorator):
    """Adds sugar to the coffee"""
    
    def get_description(self) -> str:
        return f"{self._coffee.get_description()}, Sugar"
    
    def get_cost(self) -> float:
        return self._coffee.get_cost() + 0.20


class WhippedCream(CoffeeDecorator):
    """Adds whipped cream to the coffee"""
    
    def get_description(self) -> str:
        return f"{self._coffee.get_description()}, Whipped Cream"
    
    def get_cost(self) -> float:
        return self._coffee.get_cost() + 0.70


class Vanilla(CoffeeDecorator):
    """Adds vanilla flavoring to the coffee"""
    
    def get_description(self) -> str:
        return f"{self._coffee.get_description()}, Vanilla"
    
    def get_cost(self) -> float:
        return self._coffee.get_cost() + 0.60


class Caramel(CoffeeDecorator):
    """Adds caramel flavoring to the coffee"""
    
    def get_description(self) -> str:
        return f"{self._coffee.get_description()}, Caramel"
    
    def get_cost(self) -> float:
        return self._coffee.get_cost() + 0.60


# Client Code
def print_coffee(coffee: Coffee):
    """Helper function to print coffee details"""
    print(f"Order: {coffee.get_description()}")
    print(f"Cost: ${coffee.get_cost():.2f}")
    print("-" * 50)


if __name__ == "__main__":
    print("=" * 50)
    print("DECORATOR PATTERN: COFFEE SHOP EXAMPLE")
    print("=" * 50)
    print()
    
    # Order 1: Simple coffee
    print("Order 1: Basic Coffee")
    coffee1 = SimpleCoffee()
    print_coffee(coffee1)
    print()
    
    # Order 2: Coffee with milk
    print("Order 2: Coffee with Milk")
    coffee2 = SimpleCoffee()
    coffee2 = Milk(coffee2)
    print_coffee(coffee2)
    print()
    
    # Order 3: Coffee with milk and sugar
    print("Order 3: Coffee with Milk and Sugar")
    coffee3 = SimpleCoffee()
    coffee3 = Milk(coffee3)
    coffee3 = Sugar(coffee3)
    print_coffee(coffee3)
    print()
    
    # Order 4: Fancy coffee with multiple additions
    print("Order 4: Deluxe Coffee")
    coffee4 = SimpleCoffee()
    coffee4 = Milk(coffee4)
    coffee4 = Vanilla(coffee4)
    coffee4 = WhippedCream(coffee4)
    coffee4 = Caramel(coffee4)
    print_coffee(coffee4)
    print()
    
    # Order 5: Double sugar coffee
    print("Order 5: Extra Sweet Coffee")
    coffee5 = SimpleCoffee()
    coffee5 = Sugar(coffee5)
    coffee5 = Sugar(coffee5)  # Adding sugar twice!
    coffee5 = Milk(coffee5)
    print_coffee(coffee5)
    print()
    
    print("Benefits of Decorator Pattern Demonstrated:")
    print("✓ Each decorator adds one specific responsibility")
    print("✓ Decorators can be combined in any order")
    print("✓ The same decorator can be applied multiple times")
    print("✓ No modification needed to the base Coffee class")
    print("✓ Easy to add new decorators without changing existing code")
