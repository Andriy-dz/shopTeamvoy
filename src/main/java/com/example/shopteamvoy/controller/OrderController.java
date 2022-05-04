package com.example.shopteamvoy.controller;

import com.example.shopteamvoy.dto.request.OrderRequest;
import com.example.shopteamvoy.dto.response.OrderResponse;
import com.example.shopteamvoy.service.OrderService;
import com.example.shopteamvoy.service.ProductService;
import com.example.shopteamvoy.service.mapper.OrderMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderMapper mapper;
    private final OrderService service;
    private final ProductService productService;

    public OrderController(OrderMapper mapper,
                           OrderService service,
                           ProductService productService) {
        this.mapper = mapper;
        this.service = service;
        this.productService = productService;
    }

    @PostMapping
    public OrderResponse add(@RequestBody OrderRequest dto) {
        return mapper.mapToDto(service.add(mapper.mapToModel(dto)));
    }

    @GetMapping("/{id}")
    public OrderResponse get(@PathVariable Long id) {
        return mapper.mapToDto(service.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/cheapest")
    public OrderResponse cheapestProduct(@RequestBody OrderRequest dto,
                                         @RequestParam String name) {
        dto.setProductId(productService.getCheapest(name).getId());
        return mapper.mapToDto(service.add(mapper.mapToModel(dto)));
    }

    @PutMapping("/confirm/{id}")
    public OrderResponse confirm(@PathVariable Long id) {
        return mapper.mapToDto(service.confirm(id));
    }
}
