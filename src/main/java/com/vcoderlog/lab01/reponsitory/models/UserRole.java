package com.vcoderlog.lab01.reponsitory.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vcoderlog.lab01.mapdoubleId.UserRoleId;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`User_Role`")
@IdClass(UserRoleId.class)
@Data
public class UserRole implements Serializable {
    @Id
    private Long UserId;
    @Id
    private Long RoleId;

    public UserRole() {

    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "UserId",insertable=false, updatable=false)
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "RoleId",insertable=false, updatable=false)
    private Role role;

}
