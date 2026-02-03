package com.example.decorator;

import com.example.decorator.coffee.*;
import com.example.decorator.text.*;
import com.example.decorator.burger.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class DecoratorController {

    @PostMapping("/coffee")
    public ResponseEntity<Map<String, String>> createCoffee(@RequestBody Map<String, Object> request) {
        List<String> decorators = (List<String>) request.get("decorators");
        
        Coffee coffee = new SimpleCoffee();
        
        if (decorators != null) {
            for (String decorator : decorators) {
                switch (decorator) {
                    case "milk":
                        coffee = new Milk(coffee);
                        break;
                    case "sugar":
                        coffee = new Sugar(coffee);
                        break;
                    case "whipped_cream":
                        coffee = new WhippedCream(coffee);
                        break;
                    case "vanilla":
                        coffee = new Vanilla(coffee);
                        break;
                    case "caramel":
                        coffee = new Caramel(coffee);
                        break;
                    default:
                        // Ignore unknown decorators
                        break;
                }
            }
        }
        
        Map<String, String> response = new HashMap<>();
        response.put("description", coffee.getDescription());
        response.put("cost", String.format("$%.2f", coffee.getCost()));
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/burger")
    public ResponseEntity<Map<String, String>> createBurger(@RequestBody Map<String, Object> request) {
        List<String> decorators = (List<String>) request.get("decorators");
        
        Burger burger = new SimpleBurger();
        
        if (decorators != null) {
            for (String decorator : decorators) {
                switch (decorator) {
                    case "cheese":
                        burger = new Cheese(burger);
                        break;
                    case "lettuce":
                        burger = new Lettuce(burger);
                        break;
                    case "tomato":
                        burger = new Tomato(burger);
                        break;
                    case "bacon":
                        burger = new Bacon(burger);
                        break;
                    case "pickles":
                        burger = new Pickles(burger);
                        break;
                    case "onions":
                        burger = new Onions(burger);
                        break;
                    case "special_sauce":
                        burger = new SpecialSauce(burger);
                        break;
                    case "patty":
                        burger = new Patty(burger);
                        break;
                    default:
                        // Ignore unknown decorators
                        break;
                }
            }
        }
        
        Map<String, String> response = new HashMap<>();
        response.put("description", burger.getDescription());
        response.put("cost", String.format("$%.2f", burger.getCost()));
        
        String sentencePart = burger.getSentencePart();
        String sentence = sentencePart.isEmpty() ? "" : "The burger has " + sentencePart + ".";
        response.put("sentence", sentence);
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/text")
    public ResponseEntity<Map<String, String>> formatText(@RequestBody Map<String, Object> request) {
        String textContent = (String) request.getOrDefault("text", "Hello, World!");
        List<String> decorators = (List<String>) request.get("decorators");
        Integer encryptShift = (Integer) request.getOrDefault("encrypt_shift", 3);
        
        Text text = new PlainText(textContent);
        
        if (decorators != null) {
            for (String decorator : decorators) {
                switch (decorator) {
                    case "bold":
                        text = new BoldDecorator(text);
                        break;
                    case "italic":
                        text = new ItalicDecorator(text);
                        break;
                    case "underline":
                        text = new UnderlineDecorator(text);
                        break;
                    case "uppercase":
                        text = new UpperCaseDecorator(text);
                        break;
                    case "encrypt":
                        text = new EncryptDecorator(text, encryptShift);
                        break;
                    default:
                        // Ignore unknown decorators
                        break;
                }
            }
        }
        
        Map<String, String> response = new HashMap<>();
        response.put("content", text.getContent());
        response.put("cost", String.format("$%.2f", text.getCost()));
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/coffee/examples")
    public ResponseEntity<List<Map<String, Object>>> coffeeExamples() {
        List<Map<String, Object>> examples = new ArrayList<>();
        
        // Example 1: Basic Coffee
        // SimpleCoffee.getDescription() = "Simple Coffee"
        // SimpleCoffee.getCost() = 2.00
        Coffee coffee1 = new SimpleCoffee();
        examples.add(createExample("Basic Coffee", 
            Arrays.asList(), coffee1.getDescription(), String.format("$%.2f", coffee1.getCost())));
        
        // Example 2: Coffee with Milk
        // Milk wraps SimpleCoffee
        // Milk.getDescription() = coffee.getDescription() + ", Milk"
        // Milk.getCost() = coffee.getCost() + 0.50
        Coffee coffee2 = new Milk(new SimpleCoffee());
        examples.add(createExample("Coffee with Milk", 
            Arrays.asList("milk"), coffee2.getDescription(), String.format("$%.2f", coffee2.getCost())));
        
        // Example 3: Coffee with Milk and Sugar
        // Sugar wraps (Milk wraps SimpleCoffee)
        // Final: SimpleCoffee -> Milk -> Sugar
        Coffee coffee3 = new Sugar(new Milk(new SimpleCoffee()));
        examples.add(createExample("Coffee with Milk and Sugar", 
            Arrays.asList("milk", "sugar"), coffee3.getDescription(), String.format("$%.2f", coffee3.getCost())));
        
        // Example 4: Deluxe Coffee
        // Chain: SimpleCoffee -> Milk -> Vanilla -> WhippedCream -> Caramel
        // Each decorator adds its cost and description
        Coffee coffee4 = new Caramel(
            new WhippedCream(
                new Vanilla(
                    new Milk(
                        new SimpleCoffee()
                    )
                )
            )
        );
        examples.add(createExample("Deluxe Coffee", 
            Arrays.asList("milk", "vanilla", "whipped_cream", "caramel"), 
            coffee4.getDescription(), String.format("$%.2f", coffee4.getCost())));
        
        // Example 5: Extra Sweet Coffee
        // Demonstrates adding same decorator multiple times
        // Chain: SimpleCoffee -> Sugar -> Sugar -> Milk
        Coffee coffee5 = new Milk(
            new Sugar(
                new Sugar(
                    new SimpleCoffee()
                )
            )
        );
        examples.add(createExample("Extra Sweet Coffee", 
            Arrays.asList("sugar", "sugar", "milk"), 
            coffee5.getDescription(), String.format("$%.2f", coffee5.getCost())));
        
        return ResponseEntity.ok(examples);
    }

    @GetMapping("/burger/examples")
    public ResponseEntity<List<Map<String, Object>>> burgerExamples() {
        List<Map<String, Object>> examples = new ArrayList<>();
        
        // Example 1: Simple Burger
        Burger burger1 = new SimpleBurger();
        examples.add(createExample("Simple Burger", 
            Arrays.asList(), burger1.getDescription(), String.format("$%.2f", burger1.getCost())));
        
        // Example 2: Cheeseburger
        Burger burger2 = new Cheese(new SimpleBurger());
        examples.add(createExample("Cheeseburger", 
            Arrays.asList("cheese"), burger2.getDescription(), String.format("$%.2f", burger2.getCost())));
        
        // Example 3: Classic Burger
        // Chain: SimpleBurger -> Cheese -> Lettuce -> Tomato
        Burger burger3 = new Tomato(
            new Lettuce(
                new Cheese(
                    new SimpleBurger()
                )
            )
        );
        examples.add(createExample("Classic Burger", 
            Arrays.asList("cheese", "lettuce", "tomato"), 
            burger3.getDescription(), String.format("$%.2f", burger3.getCost())));
        
        // Example 4: Bacon Cheeseburger
        // Chain: SimpleBurger -> Cheese -> Bacon
        Burger burger4 = new Bacon(
            new Cheese(
                new SimpleBurger()
            )
        );
        examples.add(createExample("Bacon Cheeseburger", 
            Arrays.asList("cheese", "bacon"), 
            burger4.getDescription(), String.format("$%.2f", burger4.getCost())));
        
        // Example 5: Deluxe Burger
        // Chain: SimpleBurger -> Cheese -> Bacon -> Lettuce -> Tomato -> Pickles -> Onions -> Special Sauce
        Burger burger5 = new SpecialSauce(
            new Onions(
                new Pickles(
                    new Tomato(
                        new Lettuce(
                            new Bacon(
                                new Cheese(
                                    new SimpleBurger()
                                )
                            )
                        )
                    )
                )
            )
        );
        examples.add(createExample("Deluxe Burger", 
            Arrays.asList("cheese", "bacon", "lettuce", "tomato", "pickles", "onions", "special_sauce"), 
            burger5.getDescription(), String.format("$%.2f", burger5.getCost())));
        
        // Example 6: Double Cheese Burger
        // Demonstrates adding same decorator multiple times
        Burger burger6 = new Cheese(
            new Cheese(
                new SimpleBurger()
            )
        );
        examples.add(createExample("Double Cheese Burger", 
            Arrays.asList("cheese", "cheese"), 
            burger6.getDescription(), String.format("$%.2f", burger6.getCost())));
        
        return ResponseEntity.ok(examples);
    }

    @GetMapping("/text/examples")
    public ResponseEntity<List<Map<String, Object>>> textExamples() {
        List<Map<String, Object>> examples = new ArrayList<>();
        
        // Example 1: Plain Text
        // PlainText.getContent() = original text
        // PlainText.getCost() = 1.00
        Text text1 = new PlainText("Hello, World!");
        examples.add(createTextExample("Plain Text", "Hello, World!", 
            Arrays.asList(), text1.getContent(), String.format("$%.2f", text1.getCost()), null));
        
        // Example 2: Uppercase Text
        // UpperCaseDecorator.getContent() = text.getContent().toUpperCase()
        // UpperCaseDecorator.getCost() = text.getCost() + 0.50
        Text text2 = new UpperCaseDecorator(new PlainText("Hello, World!"));
        examples.add(createTextExample("Uppercase Text", "Hello, World!", 
            Arrays.asList("uppercase"), text2.getContent(), String.format("$%.2f", text2.getCost()), null));
        
        // Example 3: Bold Text
        // BoldDecorator.getContent() = "<b>" + text.getContent() + "</b>"
        // BoldDecorator.getCost() = text.getCost() + 0.30
        Text text3 = new BoldDecorator(new PlainText("Hello, World!"));
        examples.add(createTextExample("Bold Text", "Hello, World!", 
            Arrays.asList("bold"), text3.getContent(), String.format("$%.2f", text3.getCost()), null));
        
        // Example 4: Bold and Italic Text
        // Chain: PlainText -> BoldDecorator -> ItalicDecorator
        // ItalicDecorator wraps the bold text with <i> tags
        Text text4 = new ItalicDecorator(
            new BoldDecorator(
                new PlainText("Hello, World!")
            )
        );
        examples.add(createTextExample("Bold and Italic Text", "Hello, World!", 
            Arrays.asList("bold", "italic"), text4.getContent(), String.format("$%.2f", text4.getCost()), null));
        
        // Example 5: Bold, Italic, and Underlined Text
        // Chain: PlainText -> BoldDecorator -> ItalicDecorator -> UnderlineDecorator
        // Each decorator wraps the previous result
        Text text5 = new UnderlineDecorator(
            new ItalicDecorator(
                new BoldDecorator(
                    new PlainText("Important Message")
                )
            )
        );
        examples.add(createTextExample("Bold, Italic, and Underlined Text", "Important Message", 
            Arrays.asList("bold", "italic", "underline"), 
            text5.getContent(), String.format("$%.2f", text5.getCost()), null));
        
        // Example 6: Uppercase and Bold Text
        // Chain: PlainText -> UpperCaseDecorator -> BoldDecorator
        // First converts to uppercase, then wraps with bold tags
        Text text6 = new BoldDecorator(
            new UpperCaseDecorator(
                new PlainText("attention")
            )
        );
        examples.add(createTextExample("Uppercase and Bold Text", "attention", 
            Arrays.asList("uppercase", "bold"), text6.getContent(), String.format("$%.2f", text6.getCost()), null));
        
        // Example 7: Encrypted Text (Caesar Cipher, shift=3)
        // EncryptDecorator.getContent() applies Caesar cipher
        // EncryptDecorator.getCost() = text.getCost() + 1.50
        Text text7 = new EncryptDecorator(new PlainText("Secret Message"), 3);
        examples.add(createTextExample("Encrypted Text (Caesar Cipher, shift=3)", "Secret Message", 
            Arrays.asList("encrypt"), text7.getContent(), String.format("$%.2f", text7.getCost()), 3));
        
        // Example 8: Encrypted, Uppercase, and Bold
        // Chain: PlainText -> EncryptDecorator -> UpperCaseDecorator -> BoldDecorator
        // Order matters: encrypts first, then uppercases encrypted text, then bolds
        Text text8 = new BoldDecorator(
            new UpperCaseDecorator(
                new EncryptDecorator(
                    new PlainText("Confidential"),
                    5
                )
            )
        );
        examples.add(createTextExample("Encrypted, Uppercase, and Bold", "Confidential", 
            Arrays.asList("encrypt", "uppercase", "bold"), 
            text8.getContent(), String.format("$%.2f", text8.getCost()), 5));
        
        return ResponseEntity.ok(examples);
    }

    private Map<String, Object> createExample(String name, List<String> decorators, 
                                              String description, String cost) {
        Map<String, Object> example = new HashMap<>();
        example.put("name", name);
        example.put("decorators", decorators);
        example.put("description", description);
        example.put("cost", cost);
        return example;
    }

    private Map<String, Object> createTextExample(String name, String text, 
                                                   List<String> decorators, String content, 
                                                   String cost, Integer encryptShift) {
        Map<String, Object> example = new HashMap<>();
        example.put("name", name);
        example.put("text", text);
        example.put("decorators", decorators);
        example.put("content", content);
        example.put("cost", cost);
        if (encryptShift != null) {
            example.put("encrypt_shift", encryptShift);
        }
        return example;
    }
}
