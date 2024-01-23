package com.example.fromscratch.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity handleBadRequest(RuntimeException e, WebRequest request) {
        final Map<String, String> body = new HashMap<>() {{
            put("message", e.getMessage());
        }};
        return ResponseEntity.badRequest().body(body);
    }
}
