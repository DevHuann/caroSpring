package com.vcoderlog.lab01.controller;

import com.vcoderlog.lab01.reponsitory.models.BoardTransaction;
import com.vcoderlog.lab01.reponsitory.models.request.board.AddBoardRequest;
import com.vcoderlog.lab01.reponsitory.models.request.board.ChessRequest;
import com.vcoderlog.lab01.reponsitory.models.request.board.EditBoardRequest;
import com.vcoderlog.lab01.reponsitory.models.request.board.GenerateBoardRequest;
import com.vcoderlog.lab01.reponsitory.models.response.BoardTransactionResponse;
import com.vcoderlog.lab01.services.BoardService;
import com.vcoderlog.lab01.services.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private ChessService chessService;

//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;


    @PostMapping("generate-new-board")
    public BoardTransaction generateNewBoard(@RequestBody GenerateBoardRequest request) throws Exception {
        var board = chessService.generateNewBoard(request.getSize());

        return boardService.addBoard(request, board);
    }

    @PostMapping("pick-chess")
    public BoardTransactionResponse pickChess(@RequestBody ChessRequest request) throws Exception {
        var board = boardService.findById(request.getBoardTransactionId());
        if (board.isEmpty()) {
            throw new Exception("Board Transaction not exist");
        }

        var boardArrs = boardService.convertStringToBoard(board.get().getBoard());
        var isWin = chessService.checkWin(boardArrs, request);


        return new BoardTransactionResponse(board.get(), isWin);
    }
//@PostMapping("pick-chess")
//public BoardTransactionResponse pickChess(@RequestBody ChessRequest request) throws Exception {
//    var board = boardService.findById(request.getBoardTransactionId());
//    if (board.isEmpty()) {
//        throw new Exception("Board Transaction not exist");
//    }
//
//    var boardArrs = boardService.convertStringToBoard(board.get().getBoard());
//    var isWin = chessService.checkWin(boardArrs, request);
//
//    BoardTransactionResponse response = new BoardTransactionResponse(board.get(), isWin);
//
//    // Gửi thông điệp qua WebSocket
//    messagingTemplate.convertAndSend("/topic/chess-updates", response);
//
//    return response;
//}

    @GetMapping("get-list-board")
    public List<BoardTransaction> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("get-transaction-by-room-id")
    public BoardTransaction gettranscationbyroomID(@RequestBody GenerateBoardRequest request) throws Exception {
       /*var roomid=boardService.findById();
       if(roomid.isPresent()){
           return roomid.get();
       }
        var board = chessService.generateNewBoard(request.getSize());

        return boardService.addBoard(request, board);*/
        var boardTransaction = boardService.findByRoomid(request.getRoomId());
        if (boardTransaction == null) {
            boardTransaction = generateNewBoard(request);
        }
        return boardTransaction;
    }

    @GetMapping("get-by-id/{boardId}")
    public BoardTransaction getBoardTransactionById(@PathVariable long boardId) {
        var boardOptional = boardService.findById(boardId);
        if (boardOptional.isPresent()) {
            return boardOptional.get();
        }

        return null;
    }
    @GetMapping("get-list-board-by-roomId/{roomId}")
    public List<BoardTransaction> getListBoardByRoomId(@PathVariable long roomId){
            var board=boardService.findByRoomId(roomId);
return board;
        }
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("add-board")
    public BoardTransaction addBoard(@RequestBody AddBoardRequest addBoardRequest) {
        return boardService.addBoard(addBoardRequest);
    }
    @PreAuthorize("hasAuthority('admin')")

    @PutMapping("edit")
    BoardTransaction editBoardData(@RequestBody EditBoardRequest editBoardRequest) {
        return boardService.editBoard(editBoardRequest);
    }
    @PreAuthorize("hasAuthority('admin')")

    @DeleteMapping("delete/{boardId}")
    Boolean delBoardData(@PathVariable long boardId) {
        return boardService.delBoard(boardId);
    }

}
