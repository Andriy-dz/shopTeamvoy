package com.example.shopteamvoy.dto.request;

import lombok.Data;

@Data
public class OrderRequest {
    private Long productId;
    private Double count;
    private Long basketId;
}
