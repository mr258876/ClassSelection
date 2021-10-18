package com.ClassSelection.data;

public enum UserRole {
    ROLE_S("ROLE_S"),
    ROLE_T("ROLE_T"),
    ROLE_M("ROLE_M"),
    ROLE_A("ROLE_A");

    private String name;

    private UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static UserRole getRole(String name) {
        UserRole role = null;
        try {
            role = UserRole.valueOf(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }
}
