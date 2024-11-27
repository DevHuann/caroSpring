package com.vcoderlog.lab01.reponsitory.models.request.board;

import lombok.Data;

@Data
public class ChessRequest {
    private int x;
    private int y;
    private int type;

    private long BoardTransactionId;


    public ChessRequest(int x, int y, int type,long BoardTransactionId) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.BoardTransactionId=BoardTransactionId;
    }


    enum ChessType {
        X, O
    }

    enum ChessMode {
        BLOCK, NON_BLOCK
    }
}
