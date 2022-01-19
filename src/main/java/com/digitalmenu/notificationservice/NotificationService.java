package com.digitalmenu.notificationservice;


import com.digitalmenu.notificationservice.models.Order;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

//    public void notifyFrontend(final String message) {
//        ResponseMessage response = new ResponseMessage(message);
//        notificationService.sendGlobalNotification();
//
//        messagingTemplate.convertAndSend("/topic/messages", response);
//    }

    public void notifyUser(final String id, final Order order) {
        messagingTemplate.convertAndSendToUser(id, "topic/update-order-status", order);
    }
}
