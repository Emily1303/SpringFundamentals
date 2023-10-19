package org.softuni.mobilelele.services.impl;

import org.softuni.mobilelele.models.dtos.LoginUserDto;
import org.softuni.mobilelele.models.dtos.RegisterUserDto;
import org.softuni.mobilelele.models.entities.User;
import org.softuni.mobilelele.models.entities.enums.Roles;
import org.softuni.mobilelele.repositories.UserRepository;
import org.softuni.mobilelele.services.UserRoleService;
import org.softuni.mobilelele.services.UserService;
import org.softuni.mobilelele.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserRoleService userRoleService;

    private PasswordEncoder passwordEncoder;

    private CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(RegisterUserDto registerUserDto) {
        User newUser = new User();
        newUser.setActive(true);
        newUser.setFirstName(registerUserDto.firstName());
        newUser.setLastName(registerUserDto.lastName());
        newUser.setUsername(registerUserDto.username());
        newUser.setPassword(passwordEncoder.encode(registerUserDto.password()));

        if (registerUserDto.role().equals("USER")) {
            newUser.setRole(userRoleService.getRole(Roles.USER));
        } else {
            newUser.setRole(userRoleService.getRole(Roles.ADMIN));
        }

        userRepository.save(newUser);
    }

    @Override
    public boolean loggedUser(LoginUserDto loginUserDto) {
        if (loginUserDto.username() != null && loginUserDto.password() != null) {

            Optional<User> byUsername = userRepository.findByUsername(loginUserDto.username());

            boolean loginSuccessful = false;

            if (byUsername.isPresent()) {
                User tryToLoginUser = byUsername.get();
                String encodedPassword = tryToLoginUser.getPassword();
                String rawPassword = loginUserDto.password();

                loginSuccessful = passwordEncoder.matches(rawPassword, encodedPassword);

                if (loginSuccessful) {
                    currentUser.setLogged(true);
                    currentUser.setUsername(loginUserDto.username());
                    currentUser.setFirstName(byUsername.get().getFirstName());
                    currentUser.setLastName(byUsername.get().getLastName());
                } else {
                    currentUser.logout();
                }
            }

            return loginSuccessful;

        }

        return false;
    }

    public void logout() {
        currentUser.logout();
    }

}
