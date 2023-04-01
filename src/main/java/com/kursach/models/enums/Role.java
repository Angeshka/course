package com.kursach.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    Менеджер,
    Пользователь;

    @Override
    public String getAuthority() {
        return name();
    }
}
