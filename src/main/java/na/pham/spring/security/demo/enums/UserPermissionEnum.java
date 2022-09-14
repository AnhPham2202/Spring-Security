package na.pham.spring.security.demo.enums;

public enum UserPermissionEnum {
    STUDENT_READ("STUDENT:READ"),
    STUDENT_WRITE("STUDENT:WRITE"),
    COURSE_WRITE("COURSE:WRITE"),
    COURSE_READ("COURSE:READ");

    private final String permission;

    UserPermissionEnum(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
