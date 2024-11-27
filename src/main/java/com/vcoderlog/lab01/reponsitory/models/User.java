package com.vcoderlog.lab01.reponsitory.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "`user`")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    @NotNull
    private String username;

    private String password;

    private boolean isDelete;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<UserTokens> userTokens;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<UserLogin> userLogins;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<UserClaims> userClaims;

    //    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRole> userRoles;
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public List<UserTokens> getUserTokens() {
        return userTokens;
    }

    public void setUserTokens(List<UserTokens> userTokens) {
        this.userTokens = userTokens;
    }

    public List<UserLogin> getUserLogins() {
        return userLogins;
    }

    public void setUserLogins(List<UserLogin> userLogins) {
        this.userLogins = userLogins;
    }

    public List<UserClaims> getUserClaims() {
        return userClaims;
    }

    public void setUserClaims(List<UserClaims> userClaims) {
        this.userClaims = userClaims;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}

