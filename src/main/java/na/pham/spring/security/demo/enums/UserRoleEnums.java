package na.pham.spring.security.demo.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum UserRoleEnums {
    STUDENT_ROLE(Collections.EMPTY_SET),
    ADMIN_ROLE(new HashSet<>(Arrays.asList(
            UserPermissionEnum.COURSE_READ,
            UserPermissionEnum.COURSE_WRITE,
            UserPermissionEnum.STUDENT_READ,
            UserPermissionEnum.STUDENT_WRITE
    )));


    private final Set<UserPermissionEnum> permissions;

    UserRoleEnums(Set<UserPermissionEnum> permission) {
        this.permissions = permission;
    }

    public Set<UserPermissionEnum> getPermission() {
        return permissions;
    }
}
