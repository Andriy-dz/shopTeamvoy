package com.example.shopteamvoy.dto.response;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private Double count;
    private Double price;
    private Long shopId;
}
