package com.vcoderlog.lab01.controller;


import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketChatController {

    @MessageMapping("/resume/{boardId}")
    @SendTo("/start/initial/{boardId}")
    public String chat(@DestinationVariable String boardId, String msg) {
        System.out.println(msg);
        return msg;
    }

}