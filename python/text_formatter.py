"""
Decorator Pattern Example: Text Formatter
==========================================

This example demonstrates the Decorator Pattern using a text formatting system.
Different decorators can be applied to add formatting like bold, italic, underline,
uppercase, and encryption.
"""

from abc import ABC, abstractmethod


# Component Interface
class Text(ABC):
    """Base interface for all text objects"""
    
    @abstractmethod
    def get_content(self) -> str:
        """Returns the content of the text"""
        pass
    
    @abstractmethod
    def get_cost(self) -> float:
        """Returns the processing cost"""
        pass


# Concrete Component
class PlainText(Text):
    """Basic text without any formatting"""
    
    def __init__(self, content: str):
        self._content = content
    
    def get_content(self) -> str:
        return self._content
    
    def get_cost(self) -> float:
        return 1.0  # Base cost for plain text


# Decorator Base Class
class TextDecorator(Text):
    """Base decorator class that wraps a Text object"""
    
    def __init__(self, text: Text):
        self._text = text
    
    @abstractmethod
    def get_content(self) -> str:
        pass
    
    @abstractmethod
    def get_cost(self) -> float:
        pass


# Concrete Decorators
class BoldDecorator(TextDecorator):
    """Wraps text with HTML bold tags"""
    
    def get_content(self) -> str:
        return f"<b>{self._text.get_content()}</b>"
    
    def get_cost(self) -> float:
        return self._text.get_cost() + 0.3


class ItalicDecorator(TextDecorator):
    """Wraps text with HTML italic tags"""
    
    def get_content(self) -> str:
        return f"<i>{self._text.get_content()}</i>"
    
    def get_cost(self) -> float:
        return self._text.get_cost() + 0.3


class UnderlineDecorator(TextDecorator):
    """Wraps text with HTML underline tags"""
    
    def get_content(self) -> str:
        return f"<u>{self._text.get_content()}</u>"
    
    def get_cost(self) -> float:
        return self._text.get_cost() + 0.2


class UpperCaseDecorator(TextDecorator):
    """Converts text to uppercase"""
    
    def get_content(self) -> str:
        return self._text.get_content().upper()
    
    def get_cost(self) -> float:
        return self._text.get_cost() + 0.5


class EncryptDecorator(TextDecorator):
    """Encrypts text using Caesar cipher"""
    
    def __init__(self, text: Text, shift: int = 3):
        super().__init__(text)
        self._shift = shift
    
    def get_content(self) -> str:
        original = self._text.get_content()
        encrypted = []
        
        for char in original:
            if char.isalpha():
                base = ord('A') if char.isupper() else ord('a')
                encrypted_char = chr((ord(char) - base + self._shift) % 26 + base)
                encrypted.append(encrypted_char)
            else:
                encrypted.append(char)
        
        return ''.join(encrypted)
    
    def get_cost(self) -> float:
        return self._text.get_cost() + 1.5


# Client Code
def print_text(text: Text):
    """Helper function to print text details"""
    print(f"Content: {text.get_content()}")
    print(f"Cost: ${text.get_cost():.2f}")
    print("-" * 60)


if __name__ == "__main__":
    print("=" * 60)
    print("DECORATOR PATTERN: TEXT FORMATTER EXAMPLE")
    print("=" * 60)
    print()
    
    # Example 1: Plain text
    print("Example 1: Plain Text")
    text1 = PlainText("Hello, World!")
    print_text(text1)
    print()
    
    # Example 2: Uppercase text
    print("Example 2: Uppercase Text")
    text2 = PlainText("Hello, World!")
    text2 = UpperCaseDecorator(text2)
    print_text(text2)
    print()
    
    # Example 3: Bold text
    print("Example 3: Bold Text")
    text3 = PlainText("Hello, World!")
    text3 = BoldDecorator(text3)
    print_text(text3)
    print()
    
    # Example 4: Bold and Italic text
    print("Example 4: Bold and Italic Text")
    text4 = PlainText("Hello, World!")
    text4 = BoldDecorator(text4)
    text4 = ItalicDecorator(text4)
    print_text(text4)
    print()
    
    # Example 5: Bold, Italic, and Underline
    print("Example 5: Bold, Italic, and Underlined Text")
    text5 = PlainText("Important Message")
    text5 = BoldDecorator(text5)
    text5 = ItalicDecorator(text5)
    text5 = UnderlineDecorator(text5)
    print_text(text5)
    print()
    
    # Example 6: Uppercase and Bold
    print("Example 6: Uppercase and Bold Text")
    text6 = PlainText("attention")
    text6 = UpperCaseDecorator(text6)
    text6 = BoldDecorator(text6)
    print_text(text6)
    print()
    
    # Example 7: Encrypted text
    print("Example 7: Encrypted Text (Caesar Cipher, shift=3)")
    text7 = PlainText("Secret Message")
    text7 = EncryptDecorator(text7, 3)
    print_text(text7)
    print()
    
    # Example 8: Multiple decorators in different order
    print("Example 8: Encrypted, then Uppercase, then Bold")
    text8 = PlainText("Confidential")
    text8 = EncryptDecorator(text8, 5)
    text8 = UpperCaseDecorator(text8)
    text8 = BoldDecorator(text8)
    print_text(text8)
    print()
    
    print("Benefits of Decorator Pattern Demonstrated:")
    print("✓ Each decorator adds one specific responsibility")
    print("✓ Decorators can be combined in any order")
    print("✓ The order of decorators affects the final result")
    print("✓ No modification needed to the base Text class")
    print("✓ Easy to add new decorators without changing existing code")
    print("✓ Cost accumulates as decorators are added")
