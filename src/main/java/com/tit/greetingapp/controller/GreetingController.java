package com.tit.greetingapp.controller;

import com.tit.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}