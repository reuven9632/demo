package com.example.demo.User;


public enum UserPermissions {
    READ("read"),
    WRITE("write"),
    SAVE("save"),
    DELETE("delete"),
    UPDATE("update");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
