package com.example.shopteamvoy.dao;

import com.example.shopteamvoy.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketDao extends JpaRepository<Basket, Long> {
}
