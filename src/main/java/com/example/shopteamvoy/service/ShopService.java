package com.example.shopteamvoy.service;

import com.example.shopteamvoy.model.Shop;

public interface ShopService {
    Shop add(Shop shop);

    Shop get(Long id);

    Shop update(Shop shop);

    void delete(Long id);
}
