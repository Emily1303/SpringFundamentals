package org.softuni.mobilelele.services;

import org.softuni.mobilelele.models.dtos.LoginUserDto;
import org.softuni.mobilelele.models.dtos.RegisterUserDto;

public interface UserService {

    void registerUser(RegisterUserDto registerUserDto);

    boolean loggedUser(LoginUserDto loginUserDto);

    void logout();
}
