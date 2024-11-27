package com.vcoderlog.lab01.reponsitory.models.request.board;


import lombok.Data;


@Data
public class AddBoardRequest {
    private long id;

    private int status;

    private String board;



    public AddBoardRequest() {
    }

    public AddBoardRequest(long id, int status, String board) {
        this.id = id;
        this.status = status;
        this.board = board;
    }


}
