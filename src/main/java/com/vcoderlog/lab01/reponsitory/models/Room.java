package com.vcoderlog.lab01.reponsitory.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`room`")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int status;
    private boolean isDelete;

    @OneToMany
    private List<BoardTransaction> boardTransactions;

    public Room() {
    }

    public Room(String name, int status) {
        this.name = name;
        this.status = status;
        this.isDelete = false;
    }
}


