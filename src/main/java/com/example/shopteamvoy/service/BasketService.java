package com.example.shopteamvoy.service;

import com.example.shopteamvoy.model.Basket;

public interface BasketService {
    Basket add(Basket basket);

    Basket get(Long id);

    Basket update(Basket basket);

    void delete(Long id);
}
