package com.vcoderlog.lab01.reponsitory.models.response;

import com.vcoderlog.lab01.reponsitory.models.BoardTransaction;
import lombok.Data;

@Data
public class BoardTransactionResponse {
    private BoardTransaction boardTransaction;
    private boolean isWin;

    public BoardTransactionResponse() {
    }

    public BoardTransactionResponse(BoardTransaction boardTransaction, boolean isWin) {
        this.boardTransaction = boardTransaction;
        this.isWin = isWin;
    }
}
