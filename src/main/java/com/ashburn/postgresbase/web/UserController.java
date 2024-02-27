package com.ashburn.postgresbase.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/")
    public String bareRoot() {
        return "Hello";
    }
}
