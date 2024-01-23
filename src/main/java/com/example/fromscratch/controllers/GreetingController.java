package com.example.fromscratch.controllers;

import com.example.fromscratch.model.Greeting;
import com.example.fromscratch.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GreetingController {
    private final GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<Greeting> greeting(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(greetingService.sayGreeting(name));
    }
}
