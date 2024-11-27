package com.vcoderlog.lab01.services.impl;

import com.vcoderlog.lab01.reponsitory.models.Role;
import com.vcoderlog.lab01.reponsitory.models.request.RoleRequest.RoleRequest;
import com.vcoderlog.lab01.reponsitory.RoleRepository;
import com.vcoderlog.lab01.services.RoleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceimpl implements RoleSevice {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role addRole(RoleRequest request) {
        Role role = new Role(request.getName());
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getlistRole() {
        return roleRepository.findAll();
    }
}
