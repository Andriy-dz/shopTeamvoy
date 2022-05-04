package com.example.shopteamvoy.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private String name;
    private Double count;
    private Double sum;
    private Boolean bought;
    private LocalDateTime timeOfPurchase;
    private Long basketId;
}
