package org.a2lpo.purchase.joint.purchase.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Роли пользователей
 */
public enum Role implements GrantedAuthority {

    USER, ORGANIZER, SUPERUSER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
