package org.softuni.mobilelele.repositories;

import org.softuni.mobilelele.models.entities.UserRole;
import org.softuni.mobilelele.models.entities.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRole(Roles role);

}
