package com.vcoderlog.lab01.controller;

import com.vcoderlog.lab01.reponsitory.models.Room;
import com.vcoderlog.lab01.reponsitory.models.request.room.AddRoomRequest;
import com.vcoderlog.lab01.reponsitory.models.request.room.DelRoomRequest;
import com.vcoderlog.lab01.reponsitory.models.request.room.EditRoomRequest;
import com.vcoderlog.lab01.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("get-room-list")
    List<Room> getRoomList() {
        return roomService.getRoomList();
    }

    @GetMapping("get-room-by-id/{roomid}")
    public Room getRoomByRoomId(@PathVariable long roomid){
        var roomOptional=roomService.finByRoomId(roomid);
        if (roomOptional.isPresent()){
            return roomOptional.get();
        }
        return null;
    }
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("add")
    Room addRoomData(@RequestBody AddRoomRequest addRoomRequest) {
        return roomService.addRoom(addRoomRequest);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping("edit")
    Room editRoomData(@RequestBody EditRoomRequest editRoomRequest) {
        return roomService.editRoom(editRoomRequest);
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("delete")
    Boolean delRoomData(@RequestBody DelRoomRequest delRoomRequest) {
        return roomService.delRoom(delRoomRequest);
    }


}
