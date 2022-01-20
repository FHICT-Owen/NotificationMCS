package com.digitalmenu.notificationservice.controllers;

import com.digitalmenu.notificationservice.NotificationService;
import com.digitalmenu.notificationservice.models.Order;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notify")
public class NotificationController {

    private final NotificationService service;

    @PostMapping("/user-order-update")
    public void sendPrivateOrderUpdate(@RequestBody Order order) {
        service.notifyUser(order.getSessionId(), order);
    }

    @PostMapping("/waiter-table-update/{sessionId}")
    public void sendPrivateTableUpdate(@PathVariable String sessionId) {
        service.notifyWaiter(sessionId);
    }

    @PostMapping("/end-user-session/{sessionId}")
    public void sendPrivateEndSession(@PathVariable String sessionId) {
        service.endUserSession(sessionId);
    }
}
