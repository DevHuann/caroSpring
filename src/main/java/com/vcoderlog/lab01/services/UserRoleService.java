package com.vcoderlog.lab01.services;

import com.vcoderlog.lab01.reponsitory.models.UserRole;
import com.vcoderlog.lab01.reponsitory.models.request.UserRoleRequesr.UserRoleRequest;

public interface UserRoleService {
    UserRole addUserRole (UserRoleRequest request);
}
