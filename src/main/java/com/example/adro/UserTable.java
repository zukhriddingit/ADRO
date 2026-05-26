package com.example.adro;

public enum UserTable {
    REGISTER("register"),
    ADMIN("admin");

    private final String tableName;

    UserTable(String tableName) {
        this.tableName = tableName;
    }

    public String tableName() {
        return tableName;
    }

    public static UserTable fromSelection(String value) {
        if (value == null) {
            return REGISTER;
        }
        if ("ADMIN".equalsIgnoreCase(value)) {
            return ADMIN;
        }
        return REGISTER;
    }
}
