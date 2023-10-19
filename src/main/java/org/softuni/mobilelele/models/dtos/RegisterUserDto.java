package org.softuni.mobilelele.models.dtos;

import org.softuni.mobilelele.models.entities.UserRole;

public record RegisterUserDto(String firstName, String lastName, String username, String password,
                              String role) {
}
