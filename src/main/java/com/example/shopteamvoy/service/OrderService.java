package com.example.shopteamvoy.service;

import com.example.shopteamvoy.model.Order;

public interface OrderService {
    Order add(Order order);

    Order get(Long id);

    Order confirm(Long id);

    void delete(Long id);

    void deleteOverdue();
}
