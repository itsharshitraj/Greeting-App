package com.tit.greetingapp.service;

import com.tit.greetingapp.model.GreetingEntity;
import com.tit.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public GreetingEntity updateGreeting(Long id, String newMessage) {
        GreetingEntity greeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
        greeting.setMessage(newMessage);
        return greetingRepository.save(greeting);
    }

    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }

}