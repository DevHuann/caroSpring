package com.vcoderlog.lab01.services.impl;

import com.vcoderlog.lab01.reponsitory.models.request.board.ChessRequest;
import com.vcoderlog.lab01.reponsitory.BoardRepository;
import com.vcoderlog.lab01.services.BoardService;
import com.vcoderlog.lab01.services.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChessServicesImpl implements ChessService {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;



    @Override
    public boolean checkWin(int[][] board, ChessRequest request) {


        board[request.getX()][request.getY()] = request.getType();
        var boardObj = boardRepository.findById(request.getBoardTransactionId()).get();

        boardObj.setBoard(boardService.convertBoardToString(board));
        boardObj.setLastPickType(request.getType());

        boolean isWin = this.checkWinDoc(board, request) ||
                this.checkWinNgang(board, request) ||
                this.checkWinCheoChinh(board, request) ||
                this.checkWinCheoPhu(board, request);



        boardRepository.save(boardObj);
        this.showBoardInConsole(board);

        return isWin;
    }

    private boolean checkWinCheoPhu(int[][] board, ChessRequest request) {
        var count = 1;
        var boardSize = board.length;
        var block = 0;
        // Kiem tra phia tren
        for (int i = 1; i <= 5; i++) {
            var x = request.getX() - i;
            var y = request.getY() + i;
            if (!validPoint(boardSize, x, y) || board[x][y] != request.getType()) {
                if (validPoint(boardSize, x, y) && board[x][y] != -1) {
                    block++;
                }
                break;
            }
            count++;
        }

        // Kiem tra phia phai
        for (int i = 1; i <= 5; i++) {
            var x = request.getX() + i;
            var y = request.getY() - i;
            if (!validPoint(boardSize, x, y) || board[x][y] != request.getType()) {
                if (validPoint(boardSize, x, y) && board[x][y] != -1) {
                    block++;
                }
                break;
            }
            count++;
        }

        return count >= 5 && block < 2;
    }

    private boolean checkWinCheoChinh(int[][] board, ChessRequest request) {
        var count = 1;
        var boardSize = board.length;
        var block = 0;
        // Kiem tra phia trai
        for (int i = 1; i <= 5; i++) {
            var x = request.getX() - i;
            var y = request.getY() - i;
            if (!validPoint(boardSize, x, y) || board[x][y] != request.getType()) {
                if (validPoint(boardSize, x, y) && board[x][y] != -1) {
                    block++;
                }
                break;
            }
            count++;
        }

        // Kiem tra phia phai
        for (int i = 1; i <= 5; i++) {
            var x = request.getX() + i;
            var y = request.getY() + i;
            if (!validPoint(boardSize, x, y) || board[x][y] != request.getType()) {
                if (validPoint(boardSize, x, y) && board[x][y] != -1) {
                    block++;
                }
                break;
            }
            count++;
        }

        return count >= 5 && block < 2;
    }

    private boolean checkWinNgang(int[][] board, ChessRequest request) {
        var count = 1;
        var boardSize = board.length;
        var block = 0;
        // Kiem tra phia trai
        for (int i = 1; i <= 5; i++) {
            var x = request.getX();
            var y = request.getY() - i;
            if (!validPoint(boardSize, x, y) || board[x][y] != request.getType()) {
                if (validPoint(boardSize, x, y) && board[x][y] != -1) {
                    block++;
                }
                break;
            }
            count++;
        }

        // Kiem tra phia phai
        for (int i = 1; i <= 5; i++) {
            var x = request.getX();
            var y = request.getY() + i;
            if (!validPoint(boardSize, x, y) || board[x][y] != request.getType()) {
                if (validPoint(boardSize, x, y) && board[x][y] != -1) {
                    block++;
                }
                break;
            }
            count++;
        }

        return count >= 5 && block < 2;
    }

    private boolean checkWinDoc(int[][] board, ChessRequest request) {
        var count = 1;
        var boardSize = board.length;
        var block = 0;
        // Kiem tra phia tren
        for (int i = 1; i <= 5; i++) {
            var x = request.getX() - i;
            var y = request.getY();
            if (!validPoint(boardSize, x, y) || board[x][y] != request.getType()) {
                if (validPoint(boardSize, x, y) && board[x][y] != -1) {
                    block++;
                }
                break;
            }
            count++;
        }

        // Kiem tra phia duoi
        for (int i = 1; i <= 5; i++) {
            var x = request.getX() + i;
            var y = request.getY();
            if (!validPoint(boardSize, x, y) || board[x][y] != request.getType()) {
                if (validPoint(boardSize, x, y) && board[x][y] != -1) {
                    block++;
                }
                break;
            }
            count++;
        }

        return count >= 5 && block < 2;
    }

    private boolean validPoint(int boardSize, int x, int y) {
        return x >= 0 && y >= 0 && x < boardSize && y < boardSize;
    }

    @Override
    public int[][] generateNewBoard(int length) {

        int board[][] = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                board[i][j] = -1;
            }
        }
        return board;
    }

    @Override
    public void showBoardInConsole(int[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%4d", board[i][j]);
            }
            System.out.println();
        }
    }
}
