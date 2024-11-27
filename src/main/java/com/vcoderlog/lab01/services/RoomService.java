package com.vcoderlog.lab01.services;

import com.vcoderlog.lab01.reponsitory.models.Room;
import com.vcoderlog.lab01.reponsitory.models.request.room.AddRoomRequest;
import com.vcoderlog.lab01.reponsitory.models.request.room.DelRoomRequest;
import com.vcoderlog.lab01.reponsitory.models.request.room.EditRoomRequest;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    public List<Room> getRoomList();

    public Room addRoom(AddRoomRequest data);

    public Room editRoom(EditRoomRequest editRoomRequest);

    public boolean delRoom(DelRoomRequest delRoomRequest);

    Optional<Room> finByRoomId(long roomId);

}
