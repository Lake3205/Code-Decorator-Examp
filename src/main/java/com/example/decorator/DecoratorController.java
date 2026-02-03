package com.example.decorator;

import com.example.decorator.coffee.*;
import com.example.decorator.text.*;
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
        
        examples.add(createExample("Basic Coffee", 
            Arrays.asList(), "Simple Coffee", "$2.00"));
        examples.add(createExample("Coffee with Milk", 
            Arrays.asList("milk"), "Simple Coffee, Milk", "$2.50"));
        examples.add(createExample("Coffee with Milk and Sugar", 
            Arrays.asList("milk", "sugar"), "Simple Coffee, Milk, Sugar", "$2.70"));
        examples.add(createExample("Deluxe Coffee", 
            Arrays.asList("milk", "vanilla", "whipped_cream", "caramel"), 
            "Simple Coffee, Milk, Vanilla, Whipped Cream, Caramel", "$4.40"));
        examples.add(createExample("Extra Sweet Coffee", 
            Arrays.asList("sugar", "sugar", "milk"), 
            "Simple Coffee, Sugar, Sugar, Milk", "$2.90"));
        
        return ResponseEntity.ok(examples);
    }

    @GetMapping("/text/examples")
    public ResponseEntity<List<Map<String, Object>>> textExamples() {
        List<Map<String, Object>> examples = new ArrayList<>();
        
        examples.add(createTextExample("Plain Text", "Hello, World!", 
            Arrays.asList(), "Hello, World!", "$1.00", null));
        examples.add(createTextExample("Uppercase Text", "Hello, World!", 
            Arrays.asList("uppercase"), "HELLO, WORLD!", "$1.50", null));
        examples.add(createTextExample("Bold Text", "Hello, World!", 
            Arrays.asList("bold"), "<b>Hello, World!</b>", "$1.30", null));
        examples.add(createTextExample("Bold and Italic Text", "Hello, World!", 
            Arrays.asList("bold", "italic"), "<i><b>Hello, World!</b></i>", "$1.60", null));
        examples.add(createTextExample("Bold, Italic, and Underlined Text", "Important Message", 
            Arrays.asList("bold", "italic", "underline"), 
            "<u><i><b>Important Message</b></i></u>", "$1.80", null));
        examples.add(createTextExample("Uppercase and Bold Text", "attention", 
            Arrays.asList("uppercase", "bold"), "<b>ATTENTION</b>", "$1.80", null));
        examples.add(createTextExample("Encrypted Text (Caesar Cipher, shift=3)", "Secret Message", 
            Arrays.asList("encrypt"), "Vhfuhw Phvvdjh", "$2.50", 3));
        examples.add(createTextExample("Encrypted, Uppercase, and Bold", "Confidential", 
            Arrays.asList("encrypt", "uppercase", "bold"), 
            "<b>HTSKNIJSYNFQ</b>", "$3.30", 5));
        
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
