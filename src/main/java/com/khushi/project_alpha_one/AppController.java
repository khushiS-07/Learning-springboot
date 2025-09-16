//package com.khushi.project_alpha_one;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@RestController
//public class AppController {
//
//    @GetMapping("/")
//    String greeting() {
//        return "welcome to the home page";
//    }
//
//    @GetMapping("/hello")
//    String sayHello(@RequestParam(value = "name", defaultValue = "world") String name) {
//        return name;
//    }
//
//    @GetMapping("/display-integer")
//    String displayInteger(@RequestParam(name = "number") int number) {
//        String msg = "your entered number is : " + number;
//        return msg;
//    }
//
//    @GetMapping("/fruits")
//    public List<String> getfruits() {
//        List<String> fruits = List.of("banana", "mango", "apple", "papaya");
//        return fruits;
//    }
//
//    @GetMapping("/vegetables")
//    public List<String> getVegetables() {
//        List<String> vegetables = List.of("aalu", "pyaj", "tamatar", "karela");
//        return vegetables;
//    }
//
//    @GetMapping("/numbers")
//    public List<Integer> getInteger() {
//        List<Integer> integer = List.of(5, 6, 7, 8, 9);
//        return integer;
//    }
//  
//    @GetMapping("/hobbies")
//    public String[] getHobbies() {
//        String[] hobbies = {"dancing", "Listening music", "coding"};
//        return hobbies;
//    }
//	
//	
//	  List<String> products = new ArrayList<String>();
//	  
//	  
//	  @GetMapping("/products")
//	  List<String> greeting(){
//		  return products;
//	  }
//	  
//	  
//	  @PostMapping("/add/product/{productName}")
//	  String addProduct( @PathVariable("productName") String product) {
//		  products.add(product);
//		  return "Product " + product + " added successfully!";
//	  }
//	  
//	  
//	  @DeleteMapping("/product/{productName}")
//	  String deleteProduct(@PathVariable("productName") String productName) {
//		  products.remove(productName);
//		  return "Product deleted sucessfully!"; 
//	  }
//	
//	  
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}