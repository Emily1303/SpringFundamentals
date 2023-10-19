package org.softuni.mobilelele.web;

import org.softuni.mobilelele.models.dtos.LoginUserDto;
import org.softuni.mobilelele.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLogInController {

    private UserService userService;

    public UserLogInController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(LoginUserDto loginUserDto) {
        boolean loginSuccessful = userService.loggedUser(loginUserDto);

        return loginSuccessful ? "redirect:/" : "auth-login";
    }

    @GetMapping("/users/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

}
