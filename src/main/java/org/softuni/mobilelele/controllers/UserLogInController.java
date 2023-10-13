package org.softuni.mobilelele.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLogInController {

    @GetMapping("/users/login")
    public String logIn() {
        return "auth-login";
    }
}
