package com.vcoderlog.lab01.reponsitory.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "`UserTokens`")
public class UserTokens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    private String LoginProvider;

    private String Name;

    private int Value;

    public UserTokens(Long userId, String loginProvider, String name, int value) {
        UserId = userId;
        LoginProvider = loginProvider;
        Name = name;
        Value = value;
    }

    public UserTokens() {

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
