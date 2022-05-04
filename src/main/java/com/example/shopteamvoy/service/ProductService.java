package com.example.shopteamvoy.service;

import com.example.shopteamvoy.model.Product;

public interface ProductService {
    Product add(Product product);

    Product get(Long id);

    Product update(Product product);

    void delete(Long id);

    Product getCheapest(String name);
}
