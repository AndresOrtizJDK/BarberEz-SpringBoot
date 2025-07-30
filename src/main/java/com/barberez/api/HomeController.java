package com.barberez.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return """
                Bienvenido a la API de BarberEZ
                Copyright © 2025 Andres Ortiz 
                """;
    }
}