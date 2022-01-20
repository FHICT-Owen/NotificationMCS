package com.digitalmenu.notificationservice.controllers;

import com.digitalmenu.notificationservice.models.Order;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

    @MessageMapping("/place-order")
    @SendTo("/topic/live-view")
    public Order processOrder(@Payload Order order) {
        return order;
    }


}