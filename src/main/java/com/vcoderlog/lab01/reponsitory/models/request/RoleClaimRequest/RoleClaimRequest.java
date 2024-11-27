package com.vcoderlog.lab01.reponsitory.models.request.RoleClaimRequest;


import lombok.Data;

@Data
public class RoleClaimRequest {
    private Long RoleId;

    private String ClaimValue;
}
