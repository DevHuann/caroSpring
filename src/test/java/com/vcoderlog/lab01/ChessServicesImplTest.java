package com.vcoderlog.lab01;

import com.vcoderlog.lab01.reponsitory.models.request.board.ChessRequest;
import com.vcoderlog.lab01.reponsitory.BoardRepository;
import com.vcoderlog.lab01.services.BoardService;
import com.vcoderlog.lab01.services.impl.ChessServicesImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChessServicesImplTest {

    @Mock
    private BoardService boardService;

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private ChessServicesImpl chessService;

    @Test
    void checkWin_ValidBoard_ReturnsTrue() {
        // Arrange
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1}
        };
        ChessRequest request = new ChessRequest(4, 4, 1, 1);

        // Act
        boolean result = chessService.checkWin(board, request);

        // Assert
        assertTrue(result);
        // Add additional assertions or verifications based on your requirements
    }

    @Test
    void checkWin_InvalidBoard_ReturnsFalse() {
        // Arrange
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 0, 1, 1}
        };
        ChessRequest request = new ChessRequest(4, 4, 1, 1);

        // Act
        boolean result = chessService.checkWin(board, request);

        // Assert
        assertFalse(result);
        // Add additional assertions or verifications based on your requirements
    }

    // Write test cases for other methods like generateNewBoard, showBoardInConsole, etc.

    @Test
    void generateNewBoard_ValidLength_ReturnsBoard() {
        // Chuẩn bị
        int length = 5;

        // Thực hiện
        int[][] board = chessService.generateNewBoard(length);

        // Xác nhận
        assertNotNull(board);
        assertEquals(length, board.length);
        assertEquals(length, board[0].length);
        // Thêm các xác nhận hoặc kiểm tra bổ sung dựa trên yêu cầu của bạn
    }

}
