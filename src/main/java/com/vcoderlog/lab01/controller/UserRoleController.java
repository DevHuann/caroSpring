package com.vcoderlog.lab01.controller;

import com.vcoderlog.lab01.reponsitory.models.UserRole;
import com.vcoderlog.lab01.reponsitory.models.request.UserRoleRequesr.UserRoleRequest;
import com.vcoderlog.lab01.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/UserRole")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/createUserRole")
    UserRole addUserRole(@RequestBody UserRoleRequest request){
        return userRoleService.addUserRole(request);
    }
}
