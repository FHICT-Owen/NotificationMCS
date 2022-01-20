package com.digitalmenu.notificationservice;


import com.digitalmenu.notificationservice.models.Order;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@AllArgsConstructor
public class NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    public void notifyUser(final String id, final Order order) {
        messagingTemplate.convertAndSendToUser(id, "topic/update-order-status", order);
    }

    public void notifyWaiter(String sessionId) {
        messagingTemplate.convertAndSend("/topic/update-table-status", sessionId);
    }

    public void endUserSession(final String id) {
        messagingTemplate.convertAndSendToUser(id, "topic/end-session", true);
    }
}
