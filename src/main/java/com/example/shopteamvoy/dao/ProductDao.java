package com.example.shopteamvoy.dao;

import com.example.shopteamvoy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDao extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p FROM Product p "
            + "WHERE p.name = ?1 AND p.price = "
            + "(SELECT MIN(p.price) FROM Product p "
            + "WHERE p.name = ?1)")
    Product findCheapest(String name);
}
