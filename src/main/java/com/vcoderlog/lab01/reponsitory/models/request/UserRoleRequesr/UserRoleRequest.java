package com.vcoderlog.lab01.reponsitory.models.request.UserRoleRequesr;

import lombok.Data;

@Data
public class UserRoleRequest {
    private long userId;
    private long roleId;
}
