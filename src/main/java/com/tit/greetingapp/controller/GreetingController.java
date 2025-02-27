package com.tit.greetingapp.controller;

import com.tit.greetingapp.model.GreetingEntity;
import com.tit.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    // UC1 - Basic Greeting Message
    @GetMapping
    public String sayHello() {
        return "Hello from BridgeLabz";
    }

    // UC2 - Use Service Layer to return Greeting Message
    @GetMapping("/service")
    public String sayHelloFromService() {
        return greetingService.getGreetingMessage();
    }

    // UC3 - Personalized Greeting
    @GetMapping("/greet")
    public String greetUser(@RequestParam(required = false) String firstName,
                            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    // UC4 - Save Greeting
    @PostMapping("/save")
    public GreetingEntity saveGreeting(@RequestBody GreetingEntity greeting) {
        return greetingService.saveGreeting(greeting);
    }

    // UC5 - Get Greeting by ID
    @GetMapping("/{id}")
    public GreetingEntity getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // UC6 - Get All Greetings
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC7 - Update Greeting
    @PutMapping("/{id}")
    public GreetingEntity updateGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        return greetingService.updateGreeting(id, newMessage);
    }
    // UC8 - Delete Greeting
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return "Greeting with ID " + id + " deleted successfully.";
    }
}