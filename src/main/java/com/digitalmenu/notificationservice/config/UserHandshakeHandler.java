package com.digitalmenu.notificationservice.config;

import com.sun.security.auth.UserPrincipal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

public class UserHandshakeHandler extends DefaultHandshakeHandler {
    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        try {
            var x = request.getHeaders().getFirst("cookie");
            assert x != null;
            var s = x.indexOf("sessionId=") + "sessionId=".length();
            var d = x.substring(s, s + 36);
            return new UserPrincipal(d);
        } catch (Exception ignored) { }
        final String randomId = UUID.randomUUID().toString();
        return new UserPrincipal(randomId);
    }
}
