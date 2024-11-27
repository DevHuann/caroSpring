package com.vcoderlog.lab01;

import com.vcoderlog.lab01.reponsitory.models.BoardTransaction;
import com.vcoderlog.lab01.reponsitory.models.request.board.*;
import com.vcoderlog.lab01.reponsitory.BoardRepository;
import com.vcoderlog.lab01.reponsitory.RoomRepository;
import com.vcoderlog.lab01.services.impl.BoardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BoardServiceImplTest {

    @Mock
    private BoardRepository boardRepository;

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private BoardServiceImpl boardService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getBoardList_ReturnsListOfBoardTransactions() {
        // Arrange
        List<BoardTransaction> boardTransactions = new ArrayList<>();
        when(boardRepository.findByIsDeleted(false)).thenReturn(boardTransactions);

        // Act
        List<BoardTransaction> result = boardService.getBoardList();

        // Assert
        assertNotNull(result);
        assertEquals(boardTransactions, result);
        verify(boardRepository, times(1)).findByIsDeleted(false);
    }

    @Test
    void addBoard_ValidAddBoardRequest_ReturnsBoardTransaction() {
        // Arrange
        AddBoardRequest addBoardRequest = new AddBoardRequest();
        addBoardRequest.setStatus(1);
        addBoardRequest.setBoard("Test Board");

        when(boardRepository.save(any())).thenReturn(new BoardTransaction(1, "Test Board"));

        // Act
        BoardTransaction result = boardService.addBoard(addBoardRequest);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getStatus());
        assertEquals("Test Board", result.getBoard());
        verify(boardRepository, times(1)).save(any());
    }

    // Write test cases for other methods like findById, addBoard(GenerateBoardRequest), editBoard, findByRoomid, findByRoomId, delBoard, convertBoardToString, convertStringToBoard, etc.

}
