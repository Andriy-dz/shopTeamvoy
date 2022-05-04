package com.example.shopteamvoy.dao;

import com.example.shopteamvoy.model.Order;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDao extends JpaRepository<Order, Long> {
    @Query(value = "SELECT o FROM Order o WHERE o.timeOfPurchase < ?1 AND o.bought = FALSE")
    List<Order> findAllOverdue(LocalDateTime date);
}
