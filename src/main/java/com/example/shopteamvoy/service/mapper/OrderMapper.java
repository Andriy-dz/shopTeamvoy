package com.example.shopteamvoy.service.mapper;

import com.example.shopteamvoy.dto.request.OrderRequest;
import com.example.shopteamvoy.dto.response.OrderResponse;
import com.example.shopteamvoy.model.Order;
import com.example.shopteamvoy.model.Product;
import com.example.shopteamvoy.service.BasketService;
import com.example.shopteamvoy.service.ProductService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements RequestDtoMapper<Order, OrderRequest>,
        ResponseDtoMapper<Order, OrderResponse> {
    private final BasketService basketService;
    private final ProductService productService;

    public OrderMapper(BasketService basketService, ProductService productService) {
        this.basketService = basketService;
        this.productService = productService;
    }

    @Override
    public Order mapToModel(OrderRequest dto) {
        Product product = productService.get(dto.getProductId());
        Order order = new Order();
        order.setName(product.getName());
        order.setProduct(product);
        order.setSum(dto.getCount() * product.getPrice());
        order.setCount(dto.getCount());
        order.setBasket(basketService.get(dto.getBasketId()));
        order.setBought(false);
        order.setTimeOfPurchase(LocalDateTime.now());
        return order;
    }

    @Override
    public OrderResponse mapToDto(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setSum(order.getSum());
        response.setCount(order.getCount());
        response.setBought(order.getBought());
        response.setBasketId(order.getBasket().getId());
        response.setName(order.getName());
        response.setTimeOfPurchase(order.getTimeOfPurchase());
        return response;
    }
}
