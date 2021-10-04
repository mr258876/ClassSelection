package com.ClassSelection.dto;

public enum UserRole {
    ROLE_A("ROLE_A"),
    ROLE_M("ROLE_M"),
    ROLE_T("ROLE_T"),
    ROLE_S("ROLE_S");

    private String name;

    private UserRole(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static UserRole getRole(String name){
        return UserRole.valueOf(name);
    }
}
