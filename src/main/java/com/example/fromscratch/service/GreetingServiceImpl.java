package com.example.fromscratch.service;

import com.example.fromscratch.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.Random;

import static java.util.Objects.isNull;

@Service
public class GreetingServiceImpl implements GreetingService {
    private final String GREETING_FORMAT = "Hello %s";
    @Override
    public Greeting sayGreeting(String name) {
        if(isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("Greeting text is required");
        }

        final Random random = new Random();
        final String greetingText = String.format(GREETING_FORMAT, name);
        return new Greeting(random.nextInt(), greetingText);
    }
}
