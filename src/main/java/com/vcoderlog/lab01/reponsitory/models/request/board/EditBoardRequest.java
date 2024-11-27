package com.vcoderlog.lab01.reponsitory.models.request.board;

import lombok.Data;

@Data
public class EditBoardRequest {
    private long id;

    private int status;

    private String board;
}
