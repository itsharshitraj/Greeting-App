package com.tit.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreetingMessage() {
        return "Hello from Service Layer!";
    }

    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName == null && lastName == null) {
            return "Hello World";
        } else if (lastName == null) {
            return "Hello " + firstName;
        } else if (firstName == null) {
            return "Hello " + lastName;
        } else {
            return "Hello " + firstName + " " + lastName;
        }
    }
}