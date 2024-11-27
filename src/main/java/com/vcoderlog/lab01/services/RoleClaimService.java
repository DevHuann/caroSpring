package com.vcoderlog.lab01.services;

import com.vcoderlog.lab01.reponsitory.models.RoleClaims;
import com.vcoderlog.lab01.reponsitory.models.request.RoleClaimRequest.RoleClaimRequest;


public interface RoleClaimService {
    RoleClaims addRoleClaim(RoleClaimRequest request);
}
