package com.vcoderlog.lab01.reponsitory.models.request.user;

import lombok.Data;

@Data
public class EditUserRequest {
    private Long id;
    private String username;
    private String password;
}
