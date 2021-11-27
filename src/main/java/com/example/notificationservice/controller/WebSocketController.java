package com.example.notificationservice.controller;

import com.example.notificationservice.order.Order;
import com.google.gson.Gson;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class WebSocketController {

    @MessageMapping("/message")
    @SendTo("/queue/live-view")
    public Order processMessageFromClient(@Payload Order order) {
//        Order order = new Gson().fromJson(order);
        System.out.println(order);
        return order;
    }

    @MessageExceptionHandler
    @SendToUser("/topic/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }
}
