package com.example.fromscratch;


import com.example.fromscratch.model.Greeting;
import com.example.fromscratch.service.GreetingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class GreetingServiceImplTest {
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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> greetingService.sayGreeting(name));

        assertEquals("Greeting text is required", exception.getMessage());
    }
}
