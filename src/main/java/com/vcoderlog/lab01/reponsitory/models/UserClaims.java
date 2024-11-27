package com.vcoderlog.lab01.reponsitory.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "`UserClaims`")
public class UserClaims {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long UserId;

    private String ClaimType;

    private String ClamValue;

    public UserClaims(Long id, Long userId, String claimType, String clamValue) {
        Id = id;
        UserId = userId;
        ClaimType = claimType;
        ClamValue = clamValue;
    }

    public UserClaims() {

    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "UserId",insertable=false, updatable=false)
    private User user;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getClaimType() {
        return ClaimType;
    }

    public void setClaimType(String claimType) {
        ClaimType = claimType;
    }

    public String getClamValue() {
        return ClamValue;
    }

    public void setClamValue(String clamValue) {
        ClamValue = clamValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
