package com.vcoderlog.lab01.reponsitory.models.response;

public class RoleClamsRespsponseDTO {
    private Long id;
    private String ClaimValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaimValue() {
        return ClaimValue;
    }

    public void setClaimValue(String claimValue) {
        ClaimValue = claimValue;
    }
}
