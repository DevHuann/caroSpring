package com.vcoderlog.lab01.services.impl;

import com.vcoderlog.lab01.reponsitory.models.BoardTransaction;
import com.vcoderlog.lab01.reponsitory.models.request.board.AddBoardRequest;
import com.vcoderlog.lab01.reponsitory.models.request.board.EditBoardRequest;
import com.vcoderlog.lab01.reponsitory.models.request.board.GenerateBoardRequest;
import com.vcoderlog.lab01.reponsitory.BoardRepository;
import com.vcoderlog.lab01.reponsitory.RoomRepository;
import com.vcoderlog.lab01.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<BoardTransaction> getBoardList() {
        var boads = boardRepository.findByIsDeleted(false);
        return boads;
    }

    @Override
    public BoardTransaction addBoard(AddBoardRequest addBoardRequest) {
        var addBoar = new BoardTransaction(addBoardRequest.getStatus(), addBoardRequest.getBoard());
        return boardRepository.save(addBoar);
    }

    @Override
    public Optional<BoardTransaction> findById(long id) {
        return boardRepository.findById(id);
    }

    @Override
    public BoardTransaction addBoard(GenerateBoardRequest request, int[][] board) throws Exception {
        var room = roomRepository.findById(request.getRoomId());
        if (room.isEmpty()) {
            throw new Exception("Room not exist!");
        }
        var addBoar = new BoardTransaction(convertBoardToString(board), room.get());
        return boardRepository.save(addBoar);
    }

    @Override
    public BoardTransaction editBoard(EditBoardRequest editBoardRequest) {
        var optionalBoard = boardRepository.findById(editBoardRequest.getId());
        if (optionalBoard.isPresent()) {
            var edit = optionalBoard.get();
            edit.setBoard(editBoardRequest.getBoard());
            return this.boardRepository.save(edit);
        }
        return null;
    }

    @Override
    public BoardTransaction findByRoomid(long roomId) throws Exception {
        var room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            var boardTransactions = boardRepository.findByRoomAndStatus(room.get(), 0);
            if (boardTransactions.size() == 0) {
                return null;
            }
            return boardTransactions.get(0);
        }
        throw new Exception("Room not exist!");
    }

    @Override
    public List<BoardTransaction> findByRoomId(long roomId) {
        var room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            var board = boardRepository.findByRoomId(room.get().getId());
            return board;
        }
        return null;
    }

    @Override
    public boolean delBoard(long id) {
        if (boardRepository.existsById(id)) {
            boardRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public String convertBoardToString(int[][] board) {
        List<String> ints = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ints.add(String.valueOf(board[i][j]));
            }
        }
        return String.join(",", ints);
    }

    @Override
    public int[][] convertStringToBoard(String s) {
        var arrs = s.split(",");
        var size = (int) Math.sqrt(arrs.length);
        int[][] result = new int[size][size];
        int x = 0, y = 0;
        for (int i = 0; i < arrs.length; i++) {
            result[x][y++] = Integer.parseInt(arrs[i]);
            if (y == size) {
                y = 0;
                x++;
            }
        }
        return result;
    }
}
