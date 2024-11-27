package com.vcoderlog.lab01.services;

import com.vcoderlog.lab01.reponsitory.models.BoardTransaction;
import com.vcoderlog.lab01.reponsitory.models.request.board.AddBoardRequest;
import com.vcoderlog.lab01.reponsitory.models.request.board.EditBoardRequest;
import com.vcoderlog.lab01.reponsitory.models.request.board.GenerateBoardRequest;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<BoardTransaction> getBoardList();

    BoardTransaction addBoard(AddBoardRequest addBoardRequest);

    Optional<BoardTransaction> findById(long id);

    BoardTransaction addBoard(GenerateBoardRequest request, int[][] board) throws Exception;

    BoardTransaction editBoard(EditBoardRequest editBoardRequest);

    BoardTransaction findByRoomid(long roomId) throws Exception;

    List<BoardTransaction> findByRoomId(long roomId);

    boolean delBoard(long id);

    String convertBoardToString(int[][] board);

    public int[][] convertStringToBoard(String s);
}
