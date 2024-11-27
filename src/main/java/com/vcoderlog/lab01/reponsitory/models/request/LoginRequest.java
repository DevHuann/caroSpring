package com.vcoderlog.lab01.reponsitory.models.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
