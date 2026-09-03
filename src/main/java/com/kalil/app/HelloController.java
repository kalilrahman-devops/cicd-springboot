package com.kalil.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello from Kalil's DevOps Pipeline!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
