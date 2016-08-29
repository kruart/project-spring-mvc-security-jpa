package ua.kruart.traineeship.model;

import org.springframework.security.core.GrantedAuthority;

/**Created by kruart on 10.07.2016.*/

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
