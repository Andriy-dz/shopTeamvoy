package com.example.shopteamvoy.dao;

import com.example.shopteamvoy.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopDao extends JpaRepository<Shop, Long> {
}
