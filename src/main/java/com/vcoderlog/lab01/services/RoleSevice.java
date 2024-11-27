package com.vcoderlog.lab01.services;

import com.vcoderlog.lab01.reponsitory.models.Role;
import com.vcoderlog.lab01.reponsitory.models.request.RoleRequest.RoleRequest;

import java.util.List;


public interface RoleSevice {
    Role addRole(RoleRequest request);
    List<Role> getlistRole();
}
