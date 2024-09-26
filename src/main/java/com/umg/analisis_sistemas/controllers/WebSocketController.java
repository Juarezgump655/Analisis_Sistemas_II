package com.umg.analisis_sistemas.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
@Controller
public class WebSocketController {

    @MessageMapping("/chat/{id}")
    @SendTo("/topic/{id}")
    public String chat(@DestinationVariable String id, String message) {
        return message;
    }



}
