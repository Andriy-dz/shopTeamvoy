package com.example.shopteamvoy.controller;

import com.example.shopteamvoy.dto.request.ShopRequest;
import com.example.shopteamvoy.dto.response.ShopResponse;
import com.example.shopteamvoy.model.Shop;
import com.example.shopteamvoy.service.ShopService;
import com.example.shopteamvoy.service.mapper.ShopMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shops")
public class ShopController {
    private final ShopMapper mapper;
    private final ShopService service;

    public ShopController(ShopMapper mapper, ShopService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public ShopResponse add(@RequestBody ShopRequest dto) {
        return mapper.mapToDto(service.add(mapper.mapToModel(dto)));
    }

    @GetMapping("/{id}")
    public ShopResponse get(@PathVariable Long id) {
        return mapper.mapToDto(service.get(id));
    }

    @PutMapping("/{id}")
    public ShopResponse update(@PathVariable Long id, @RequestBody ShopRequest dto) {
        Shop shop = mapper.mapToModel(dto);
        shop.setId(id);
        return mapper.mapToDto(service.update(shop));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
