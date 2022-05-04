package com.example.shopteamvoy.controller;

import com.example.shopteamvoy.dto.request.BasketRequest;
import com.example.shopteamvoy.dto.response.BasketResponse;
import com.example.shopteamvoy.model.Basket;
import com.example.shopteamvoy.service.BasketService;
import com.example.shopteamvoy.service.mapper.BasketMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    private final BasketMapper mapper;
    private final BasketService service;

    public BasketController(BasketMapper mapper, BasketService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public BasketResponse add(@RequestBody BasketRequest dto) {
        return mapper.mapToDto(service.add(mapper.mapToModel(dto)));
    }

    @GetMapping("/{id}")
    public BasketResponse get(@PathVariable Long id) {
        return mapper.mapToDto(service.get(id));
    }

    @PutMapping("/{id}")
    public BasketResponse update(@PathVariable Long id, @RequestBody BasketRequest dto) {
        Basket basket = mapper.mapToModel(dto);
        basket.setId(id);
        return mapper.mapToDto(service.update(basket));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
