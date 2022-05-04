package com.example.shopteamvoy.service.impl;

import com.example.shopteamvoy.dao.ShopDao;
import com.example.shopteamvoy.model.Shop;
import com.example.shopteamvoy.service.ShopService;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopDao dao;

    public ShopServiceImpl(ShopDao dao) {
        this.dao = dao;
    }

    @Override
    public Shop add(Shop shop) {
        return dao.save(shop);
    }

    @Override
    public Shop get(Long id) {
        return dao.getById(id);
    }

    @Override
    public Shop update(Shop shop) {
        return dao.save(shop);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }
}
