package com.digitalmenu.notificationservice.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import java.util.List;

@Data
public class Order {
    @NotNull
    private String sessionId;
    @NotNull
    private Integer tableId;
    @NotNull
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
    @Min(0)
    private double totalPrice;
}
