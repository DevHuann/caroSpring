package com.vcoderlog.lab01.services.impl;

import com.vcoderlog.lab01.reponsitory.models.UserRole;
import com.vcoderlog.lab01.reponsitory.models.request.UserRoleRequesr.UserRoleRequest;
import com.vcoderlog.lab01.reponsitory.RoleRepository;
import com.vcoderlog.lab01.reponsitory.UserRepository;
import com.vcoderlog.lab01.reponsitory.UserRoleRepository;
import com.vcoderlog.lab01.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceimpl implements UserRoleService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole addUserRole(UserRoleRequest request) {
        var roles = roleRepository.findById(request.getRoleId());
        var users = userRepository.findById(request.getUserId());

        var userrole = new UserRole();

        if (roles.isPresent()){
            var role = roles.get();
            var roleId = role.getId();

            userrole.setRoleId(roleId);
        }
        if (users.isPresent()){
            var user = users.get();
            var userId = user.getId();

            userrole.setUserId(userId);
        }

        return userRoleRepository.save(userrole);
    }
}
