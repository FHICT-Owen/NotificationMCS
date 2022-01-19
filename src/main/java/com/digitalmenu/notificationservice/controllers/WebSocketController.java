package com.digitalmenu.notificationservice.controllers;

import com.digitalmenu.notificationservice.models.Order;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/place-order")
    @SendTo("/topic/live-view")
    public Order processOrder(@Payload Order order) {
        return order;
    }

//    @MessageMapping("/private-message")
//    @SendToUser("/topic/live-view")
//    public Order processPrivateMessageFromClient(@Payload Order order) {
//        return order;
//    }

//    @MessageExceptionHandler
//    @SendToUser("/topic/errors")
//    public String handleException(Throwable exception) {
//        return exception.getMessage();
//    }
}