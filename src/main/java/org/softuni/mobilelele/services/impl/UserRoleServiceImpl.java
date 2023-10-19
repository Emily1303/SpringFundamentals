package org.softuni.mobilelele.services.impl;

import org.softuni.mobilelele.models.entities.UserRole;
import org.softuni.mobilelele.models.entities.enums.Roles;
import org.softuni.mobilelele.repositories.UserRoleRepository;
import org.softuni.mobilelele.services.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole getRole(Roles role) {
        return userRoleRepository.findByRole(role);
    }

}
