package net.godaa.SpringSecurity.models;

public enum EPermissions {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    STUDENT_DELETE("student:delete"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    EPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
