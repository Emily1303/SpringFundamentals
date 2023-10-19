package org.softuni.mobilelele.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component(value = "currentUser")
@SessionScope
public class CurrentUser {

    private String username;

    private boolean isLogged;

    private String firstName;

    private String lastName;

    public CurrentUser() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public void logout() {
        setUsername(null);
        setLogged(false);
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();

        if (firstName != null) {
            sb.append(firstName);

            if (lastName != null) {
                sb.append(" ");
                sb.append(lastName);
            }
        }

        return sb.toString();
    }
}
