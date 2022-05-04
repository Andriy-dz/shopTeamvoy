package com.example.shopteamvoy.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Double count;
    private Double price;
    private Long shopId;
}
