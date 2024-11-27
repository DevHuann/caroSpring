package com.vcoderlog.lab01.reponsitory.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "`UserLogin`")
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;
    @Column(nullable = false, unique = true)
    private String LoginProvider;

    private String ProviderKey;

    private String ProviderDisplayName;

    public UserLogin(Long userId, String loginProvider, String providerKey, String providerDisplayName) {
        UserId = userId;
        LoginProvider = loginProvider;
        ProviderKey = providerKey;
        ProviderDisplayName = providerDisplayName;
    }

    public UserLogin() {

    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "UserId",insertable=false, updatable=false)
    private User user;

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getLoginProvider() {
        return LoginProvider;
    }

    public void setLoginProvider(String loginProvider) {
        LoginProvider = loginProvider;
    }

    public String getProviderKey() {
        return ProviderKey;
    }

    public void setProviderKey(String providerKey) {
        ProviderKey = providerKey;
    }

    public String getProviderDisplayName() {
        return ProviderDisplayName;
    }

    public void setProviderDisplayName(String providerDisplayName) {
        ProviderDisplayName = providerDisplayName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
