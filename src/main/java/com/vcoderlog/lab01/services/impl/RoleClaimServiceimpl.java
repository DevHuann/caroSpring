package com.vcoderlog.lab01.services.impl;

import com.vcoderlog.lab01.reponsitory.models.RoleClaims;
import com.vcoderlog.lab01.reponsitory.models.request.RoleClaimRequest.RoleClaimRequest;
import com.vcoderlog.lab01.reponsitory.RoleClaimRepository;
import com.vcoderlog.lab01.reponsitory.RoleRepository;
import com.vcoderlog.lab01.services.RoleClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleClaimServiceimpl implements RoleClaimService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleClaimRepository roleClaimRepository;

    @Override
    public RoleClaims addRoleClaim(RoleClaimRequest request) {
        var roles = roleRepository.findById(request.getRoleId());
        if (roles.isPresent()){
            var role = roles.get();
            var roleClaims = new RoleClaims(request.getClaimValue(), role);
            return roleClaimRepository.save(roleClaims);
        }
        return null;
    }
}
