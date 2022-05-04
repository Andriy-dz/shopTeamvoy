package com.example.shopteamvoy.controller;

import com.example.shopteamvoy.dto.request.ProductRequest;
import com.example.shopteamvoy.dto.response.ProductResponse;
import com.example.shopteamvoy.model.Product;
import com.example.shopteamvoy.service.ProductService;
import com.example.shopteamvoy.service.mapper.ProductMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductMapper mapper;
    private final ProductService service;

    public ProductController(ProductMapper mapper, ProductService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public ProductResponse add(@RequestBody ProductRequest dto) {
        return mapper.mapToDto(service.add(mapper.mapToModel(dto)));
    }

    @GetMapping("/{id}")
    public ProductResponse get(@PathVariable Long id) {
        return mapper.mapToDto(service.get(id));
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @RequestBody ProductRequest dto) {
        Product product = mapper.mapToModel(dto);
        product.setId(id);
        return mapper.mapToDto(service.update(product));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
