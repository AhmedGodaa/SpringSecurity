package net.godaa.SpringSecurity.models;

public enum EPermissions {
    READ("student:read"),
    WRITE("student:write"),
    DELETE("student:delete");

    private String permission;

    EPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
