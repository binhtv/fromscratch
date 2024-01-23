package com.example.fromscratch;


import com.example.fromscratch.model.Greeting;
import com.example.fromscratch.service.GreetingServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class GreetingServiceImplTest {
    @InjectMocks
    private GreetingServiceImpl greetingService;

    @Test
    public void testGreetingWithValidGreetingText() {
        final String name = "Binh";

        Greeting actual = greetingService.sayGreeting(name);

        assertNotNull(actual);
        assertEquals(actual.getContent(), "Hello " + name);
    }

    @Test
    public void testGreetingWithEmptyGreetingText() {
        final String name = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           greetingService.sayGreeting(name);
        });

        assertEquals("Greeting text is required", exception.getMessage());
    }
}
