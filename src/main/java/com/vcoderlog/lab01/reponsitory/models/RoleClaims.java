package com.vcoderlog.lab01.reponsitory.models;

import javax.persistence.*;

@Entity
@Table(name = "`RoleClamims`")
public class RoleClaims {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ClaimValue;
    public RoleClaims() {
    }

    @ManyToOne
    private Role role;


    public RoleClaims(String claimValue, Role role) {
        this.ClaimValue = claimValue;
        this.role = role;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
