package com.vcoderlog.lab01.reponsitory.models.request.room;

import lombok.Data;

@Data
public class AddRoomRequest {
    private String name;
    private int status;
    private boolean isDelete;
}
