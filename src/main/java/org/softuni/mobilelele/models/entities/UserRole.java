package org.softuni.mobilelele.models.entities;

import jakarta.persistence.*;
import org.softuni.mobilelele.models.entities.enums.Roles;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Roles role;

    public UserRole() {

    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

}
