package com.tit.greetingapp.controller;

import com.tit.greetingapp.model.GreetingEntity;
import com.tit.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}