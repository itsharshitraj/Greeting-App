package com.tit.greetingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class GreetingController {

    // UC1 - Basic Greeting Message
    @GetMapping
    public String sayHello() {
        return "Hello from BridgeLabz";
    }
}