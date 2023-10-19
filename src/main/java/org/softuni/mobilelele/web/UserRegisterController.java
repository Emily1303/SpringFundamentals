package org.softuni.mobilelele.web;

import org.softuni.mobilelele.models.dtos.RegisterUserDto;
import org.softuni.mobilelele.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegisterController {

    private UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("users/register")
    public String register(RegisterUserDto registerUserDto) {
        userService.registerUser(registerUserDto);

        return "redirect:/";
    }

}
