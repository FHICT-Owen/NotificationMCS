package com.digitalmenu.notificationservice.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Order {
    private Integer sessionId;
    @NotNull
    @Column(nullable = false)
    private Integer tableNumber;
    @NotEmpty
    private List<String> dishes;
    private String comments;
    @NotNull
    private OrderState orderState;
    @NotNull
    private Long timeStamp;

    enum OrderState {
        isUnapproved,
        isApproved,
        isBeingPrepared,
        isReady,
        isArchived,
        isCanceled
    }
}
