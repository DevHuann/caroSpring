package com.vcoderlog.lab01.controller;

import com.vcoderlog.lab01.reponsitory.models.request.board.ChessRequest;
import com.vcoderlog.lab01.services.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chess")
public class ChessController {

    @Autowired
    private ChessService chessService;

    @PostMapping("reset")
    public boolean resetBoard(@RequestBody ChessRequest request) {
        var board = chessService.generateNewBoard(15);
        chessService.showBoardInConsole(board);
        return chessService.checkWin(board, request);
    }

}
