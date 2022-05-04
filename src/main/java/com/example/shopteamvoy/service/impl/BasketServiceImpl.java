package com.example.shopteamvoy.service.impl;

import com.example.shopteamvoy.dao.BasketDao;
import com.example.shopteamvoy.model.Basket;
import com.example.shopteamvoy.service.BasketService;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {
    private final BasketDao dao;

    public BasketServiceImpl(BasketDao dao) {
        this.dao = dao;
    }

    @Override
    public Basket add(Basket basket) {
        return dao.save(basket);
    }

    @Override
    public Basket get(Long id) {
        return dao.getById(id);
    }

    @Override
    public Basket update(Basket basket) {
        return dao.save(basket);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }
}
