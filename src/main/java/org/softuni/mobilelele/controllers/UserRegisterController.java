package org.softuni.mobilelele.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRegisterController {

    @GetMapping("/users/register")
    public String register() {
        return "auth-register";
    }
}
