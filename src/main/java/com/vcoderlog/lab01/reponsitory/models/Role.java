package com.vcoderlog.lab01.reponsitory.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`Role`")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String NormalizedName;

    private String ConcurrencyStamp;



    public Role() {

    }

    public Role(String name) {

        this.name = name;
    }

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private  List<RoleClaims> roleClaims;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNormalizedName() {
        return NormalizedName;
    }

    public void setNormalizedName(String normalizedName) {
        NormalizedName = normalizedName;
    }

    public String getConcurrencyStamp() {
        return ConcurrencyStamp;
    }

    public void setConcurrencyStamp(String concurrencyStamp) {
        ConcurrencyStamp = concurrencyStamp;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<RoleClaims> getRoleClaims() {
        return roleClaims;
    }

    public void setRoleClaims(List<RoleClaims> roleClaims) {
        this.roleClaims = roleClaims;
    }
}
