package com.digitalmenu.notificationservice.controllers;

import com.digitalmenu.notificationservice.NotificationService;
import com.digitalmenu.notificationservice.models.Order;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notify")
public class NotificationController {

    private final NotificationService service;

    @PostMapping("/user-order-update")
    public void sendPrivateMessage(@RequestBody Order order) {
        service.notifyUser(order.getSessionId(), order);
    }
}
