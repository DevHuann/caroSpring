package com.vcoderlog.lab01.reponsitory.models.request.board;

import lombok.Data;

@Data
public class GenerateBoardRequest {
    private long roomId;
    private int size;
}
