package com.vcoderlog.lab01.services;

import com.vcoderlog.lab01.reponsitory.models.request.board.ChessRequest;

public interface ChessService {


    boolean checkWin(int[][] board, ChessRequest request);
    int[][] generateNewBoard(int length);
    void showBoardInConsole(int[][] board);

}
