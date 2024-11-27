package com.vcoderlog.lab01.reponsitory.models;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "`board_transtaion`")
@DynamicUpdate
@Data
public class BoardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int status;

    @Column(columnDefinition="TEXT")
    private String board;

    @ManyToOne
    private Room room;

    @ManyToOne
    private User host;

    @ManyToOne
    private User player;

    private boolean isDeleted;

    @Column(columnDefinition="INTEGER default '-1'")
    private int lastPickType;

    @ManyToOne
    private User winner;

    public BoardTransaction() {

    }

    public BoardTransaction(int status, String board) {
        this.status = status;
        this.board = board;
   }

    public BoardTransaction(String board, Room room) {
        this.board = board;
        this.room = room;
    }
}
