package com.vcoderlog.lab01.mapdoubleId;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class UserRoleId implements Serializable {
    private Long UserId;

    private Long RoleId;

    public UserRoleId() {
    }

    public UserRoleId(Long userId, Long roleId) {
        UserId = userId;
        RoleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleId accountType = (UserRoleId) o;
        return UserId.equals(accountType.UserId) &&
                RoleId.equals(accountType.RoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId, RoleId);
    }
}
