"""
Web GUI for Decorator Pattern Examples
=======================================

Flask application that demonstrates the Decorator Pattern with
interactive examples for both Coffee Shop and Text Formatter.
"""

from flask import Flask, render_template, request, jsonify
from python.coffee_shop import (
    SimpleCoffee, Milk, Sugar, WhippedCream, Vanilla, Caramel
)
from python.text_formatter import (
    PlainText, BoldDecorator, ItalicDecorator, UnderlineDecorator,
    UpperCaseDecorator, EncryptDecorator
)

app = Flask(__name__)


@app.route('/')
def index():
    """Main page with both examples"""
    return render_template('index.html')


@app.route('/api/coffee', methods=['POST'])
def create_coffee():
    """API endpoint to create decorated coffee"""
    data = request.get_json()
    decorators = data.get('decorators', [])
    
    # Start with simple coffee
    coffee = SimpleCoffee()
    
    # Apply decorators
    for decorator in decorators:
        if decorator == 'milk':
            coffee = Milk(coffee)
        elif decorator == 'sugar':
            coffee = Sugar(coffee)
        elif decorator == 'whipped_cream':
            coffee = WhippedCream(coffee)
        elif decorator == 'vanilla':
            coffee = Vanilla(coffee)
        elif decorator == 'caramel':
            coffee = Caramel(coffee)
    
    return jsonify({
        'description': coffee.get_description(),
        'cost': f"${coffee.get_cost():.2f}"
    })


@app.route('/api/text', methods=['POST'])
def format_text():
    """API endpoint to format text with decorators"""
    data = request.get_json()
    text_content = data.get('text', 'Hello, World!')
    decorators = data.get('decorators', [])
    encrypt_shift = data.get('encrypt_shift', 3)
    
    # Start with plain text
    text = PlainText(text_content)
    
    # Apply decorators in order
    for decorator in decorators:
        if decorator == 'bold':
            text = BoldDecorator(text)
        elif decorator == 'italic':
            text = ItalicDecorator(text)
        elif decorator == 'underline':
            text = UnderlineDecorator(text)
        elif decorator == 'uppercase':
            text = UpperCaseDecorator(text)
        elif decorator == 'encrypt':
            text = EncryptDecorator(text, encrypt_shift)
    
    return jsonify({
        'content': text.get_content(),
        'cost': f"${text.get_cost():.2f}"
    })


@app.route('/api/coffee/examples')
def coffee_examples():
    """Get predefined coffee examples"""
    examples = [
        {
            'name': 'Basic Coffee',
            'decorators': [],
            'description': 'Simple Coffee',
            'cost': '$2.00'
        },
        {
            'name': 'Coffee with Milk',
            'decorators': ['milk'],
            'description': 'Simple Coffee, Milk',
            'cost': '$2.50'
        },
        {
            'name': 'Coffee with Milk and Sugar',
            'decorators': ['milk', 'sugar'],
            'description': 'Simple Coffee, Milk, Sugar',
            'cost': '$2.70'
        },
        {
            'name': 'Deluxe Coffee',
            'decorators': ['milk', 'vanilla', 'whipped_cream', 'caramel'],
            'description': 'Simple Coffee, Milk, Vanilla, Whipped Cream, Caramel',
            'cost': '$4.40'
        },
        {
            'name': 'Extra Sweet Coffee',
            'decorators': ['sugar', 'sugar', 'milk'],
            'description': 'Simple Coffee, Sugar, Sugar, Milk',
            'cost': '$2.90'
        }
    ]
    return jsonify(examples)


@app.route('/api/text/examples')
def text_examples():
    """Get predefined text formatting examples"""
    examples = [
        {
            'name': 'Plain Text',
            'text': 'Hello, World!',
            'decorators': [],
            'content': 'Hello, World!',
            'cost': '$1.00'
        },
        {
            'name': 'Uppercase Text',
            'text': 'Hello, World!',
            'decorators': ['uppercase'],
            'content': 'HELLO, WORLD!',
            'cost': '$1.50'
        },
        {
            'name': 'Bold Text',
            'text': 'Hello, World!',
            'decorators': ['bold'],
            'content': '<b>Hello, World!</b>',
            'cost': '$1.30'
        },
        {
            'name': 'Bold and Italic Text',
            'text': 'Hello, World!',
            'decorators': ['bold', 'italic'],
            'content': '<i><b>Hello, World!</b></i>',
            'cost': '$1.60'
        },
        {
            'name': 'Bold, Italic, and Underlined Text',
            'text': 'Important Message',
            'decorators': ['bold', 'italic', 'underline'],
            'content': '<u><i><b>Important Message</b></i></u>',
            'cost': '$1.80'
        },
        {
            'name': 'Uppercase and Bold Text',
            'text': 'attention',
            'decorators': ['uppercase', 'bold'],
            'content': '<b>ATTENTION</b>',
            'cost': '$1.80'
        },
        {
            'name': 'Encrypted Text (Caesar Cipher, shift=3)',
            'text': 'Secret Message',
            'decorators': ['encrypt'],
            'content': 'Vhfuhw Phvvdjh',
            'cost': '$2.50',
            'encrypt_shift': 3
        },
        {
            'name': 'Encrypted, Uppercase, and Bold',
            'text': 'Confidential',
            'decorators': ['encrypt', 'uppercase', 'bold'],
            'content': '<b>HTSKNIJSYNFQ</b>',
            'cost': '$3.30',
            'encrypt_shift': 5
        }
    ]
    return jsonify(examples)


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
