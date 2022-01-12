package com.example.notificationservice.order;

import lombok.Data;

import java.util.Set;

@Data
public class Order {
    private Integer id;
    private Integer sessionId;
    private Set<String> dishes;
    private String comments;
    private Boolean isApproved;
    private Boolean isCanceled;
    private Boolean isBeingPrepared;
    private Boolean isReady;
    private Long timeStamp;
}
