package com.example.user_service.age;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ages")
@RestController
public class AgeController {
    
    @GetMapping
    public String test() {
        return "AGE";
    }
}
