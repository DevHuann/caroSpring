package com.vcoderlog.lab01.reponsitory.models.response;

import lombok.Data;

@Data
public class RandomStuff {
    private String message;

    public RandomStuff(String message) {
        this.message = message;
    }
}
