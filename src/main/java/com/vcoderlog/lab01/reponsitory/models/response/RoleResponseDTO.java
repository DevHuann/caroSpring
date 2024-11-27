package com.vcoderlog.lab01.reponsitory.models.response;

import java.util.List;

public class RoleResponseDTO {
    private Long id;
    private String Name;
    private List<RoleClamsRespsponseDTO> roleClaims;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<RoleClamsRespsponseDTO> getRoleClaims() {
        return roleClaims;
    }

    public void setRoleClaims(List<RoleClamsRespsponseDTO> roleClaims) {
        this.roleClaims = roleClaims;
    }
}
