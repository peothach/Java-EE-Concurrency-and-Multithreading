package com.javaeeconcurrency.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class GreetUser {

    @GetMapping("/greetUser")
    public String greetUser() {
        return "Java EE concurrency start!";
    }
}
