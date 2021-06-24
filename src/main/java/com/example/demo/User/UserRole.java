package com.example.demo.User;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.User.UserPermissions.*;

public enum UserRole {
    USER(Sets.newHashSet(READ, WRITE)),
    ADMIN(Sets.newHashSet(READ, WRITE, SAVE, UPDATE, DELETE)),
    STUDENT(Sets.newHashSet(READ));

    private final Set<UserPermissions> permissions;

    UserRole(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthority(){
        Set<SimpleGrantedAuthority> authorities = getPermissions()
                .stream()
                .map(userPermissions -> new SimpleGrantedAuthority(userPermissions.getPermission()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
