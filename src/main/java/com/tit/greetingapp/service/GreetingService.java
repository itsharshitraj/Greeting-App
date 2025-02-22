package com.tit.greetingapp.service;

import com.tit.greetingapp.model.GreetingEntity;
import com.tit.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GreetingRepository greetingRepository;

    public GreetingEntity saveGreeting(GreetingEntity greeting) {
        return greetingRepository.save(greeting);
    }

    public GreetingEntity getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }

}