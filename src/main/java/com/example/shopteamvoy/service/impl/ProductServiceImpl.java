package com.example.shopteamvoy.service.impl;

import com.example.shopteamvoy.dao.ProductDao;
import com.example.shopteamvoy.model.Product;
import com.example.shopteamvoy.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao dao;

    public ProductServiceImpl(ProductDao dao) {
        this.dao = dao;
    }

    @Override
    public Product add(Product product) {
        return dao.save(product);
    }

    @Override
    public Product get(Long id) {
        return dao.getById(id);
    }

    @Override
    public Product update(Product product) {
        return dao.save(product);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Product getCheapest(String name) {
        return dao.findCheapest(name);
    }
}
