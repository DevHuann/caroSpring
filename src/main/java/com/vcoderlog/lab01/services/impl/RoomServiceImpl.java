package com.vcoderlog.lab01.services.impl;

import com.vcoderlog.lab01.reponsitory.models.Room;
import com.vcoderlog.lab01.reponsitory.models.request.room.AddRoomRequest;
import com.vcoderlog.lab01.reponsitory.models.request.room.DelRoomRequest;
import com.vcoderlog.lab01.reponsitory.models.request.room.EditRoomRequest;
import com.vcoderlog.lab01.reponsitory.RoomRepository;
import com.vcoderlog.lab01.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getRoomList() {
        return roomRepository.findByIsDelete(false);
    }

    @Override
    public Room addRoom(AddRoomRequest data) {
        var newRoom = new Room(data.getName(), data.getStatus());
        return roomRepository.save(newRoom);
    }

    @Override
    public Room editRoom(EditRoomRequest editRoomRequest) {
        var optionalRoom = roomRepository.findById(editRoomRequest.getId());
        if (optionalRoom.isPresent()){
            var editRoom = optionalRoom.get();
            editRoom.setName(editRoomRequest.getName());
            return this.roomRepository.save(editRoom);
        }
        return null;
    }

    @Override
    public boolean delRoom(DelRoomRequest delRoomRequest) {
        var delId = roomRepository.findAllById(delRoomRequest.getId());
        if (delId != null){
            roomRepository.delete(delId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Room> finByRoomId(long roomId) {
        return roomRepository.findById(roomId);
    }


}
