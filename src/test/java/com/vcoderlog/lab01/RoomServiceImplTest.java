package com.vcoderlog.lab01;

import com.vcoderlog.lab01.reponsitory.models.Room;
import com.vcoderlog.lab01.reponsitory.models.request.room.AddRoomRequest;
import com.vcoderlog.lab01.reponsitory.models.request.room.DelRoomRequest;
import com.vcoderlog.lab01.reponsitory.models.request.room.EditRoomRequest;
import com.vcoderlog.lab01.reponsitory.RoomRepository;
import com.vcoderlog.lab01.services.RoomService;
import com.vcoderlog.lab01.services.impl.RoomServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoomServiceImplTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomServiceImpl roomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getRoomList_ReturnsListOfRooms() {
        // Arrange
        when(roomRepository.findByIsDelete(false)).thenReturn(Collections.singletonList(new Room("Room 1", 1)));

        // Act
        List<Room> roomList = roomService.getRoomList();

        // Assert
        assertNotNull(roomList);
        assertFalse(roomList.isEmpty());
        assertEquals(1, roomList.size());
        assertEquals("Room 1", roomList.get(0).getName());
//        assertEquals("Available", roomList.get(0).getStatus());
        verify(roomRepository, times(1)).findByIsDelete(false);
    }

    @Test
    void addRoom_ValidRoom_ReturnsNewRoom() {
        // Arrange
        AddRoomRequest request = new AddRoomRequest();
        request.setName("New Room");
        when(roomRepository.save(any())).thenReturn(new Room("New Room", 1));

        // Act
        Room addedRoom = roomService.addRoom(request);

        // Assert
        assertNotNull(addedRoom);
        assertEquals("New Room", addedRoom.getName());
        verify(roomRepository, times(1)).save(any());
    }

    // Add more test cases for other methods like editRoom, delRoom, findByRoomId, etc.

}
