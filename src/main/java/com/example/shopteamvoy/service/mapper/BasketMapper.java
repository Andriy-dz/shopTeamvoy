package com.example.shopteamvoy.service.mapper;

import com.example.shopteamvoy.dto.request.BasketRequest;
import com.example.shopteamvoy.dto.response.BasketResponse;
import com.example.shopteamvoy.model.Basket;
import com.example.shopteamvoy.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class BasketMapper implements RequestDtoMapper<Basket, BasketRequest>,
        ResponseDtoMapper<Basket, BasketResponse> {
    private final UserService userService;

    public BasketMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Basket mapToModel(BasketRequest dto) {
        Basket basket = new Basket();
        basket.setUser(userService.get(dto.getUserId()));
        return basket;
    }

    @Override
    public BasketResponse mapToDto(Basket basket) {
        BasketResponse response = new BasketResponse();
        response.setId(basket.getId());
        response.setUserId(basket.getUser().getId());
        return response;
    }
}
