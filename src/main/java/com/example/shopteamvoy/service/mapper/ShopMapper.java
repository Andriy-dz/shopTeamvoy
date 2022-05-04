package com.example.shopteamvoy.service.mapper;

import com.example.shopteamvoy.dto.request.ShopRequest;
import com.example.shopteamvoy.dto.response.ShopResponse;
import com.example.shopteamvoy.model.Shop;
import org.springframework.stereotype.Component;

@Component
public class ShopMapper implements RequestDtoMapper<Shop, ShopRequest>,
        ResponseDtoMapper<Shop, ShopResponse> {
    @Override
    public Shop mapToModel(ShopRequest dto) {
        Shop shop = new Shop();
        shop.setName(dto.getName());
        return shop;
    }

    @Override
    public ShopResponse mapToDto(Shop shop) {
        ShopResponse response = new ShopResponse();
        response.setId(shop.getId());
        response.setName(shop.getName());
        return response;
    }
}
