package org.softuni.mobilelele.services;

import org.softuni.mobilelele.models.entities.UserRole;
import org.softuni.mobilelele.models.entities.enums.Roles;

public interface UserRoleService {

    UserRole getRole(Roles role);

}
