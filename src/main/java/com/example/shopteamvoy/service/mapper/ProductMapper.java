package com.example.shopteamvoy.service.mapper;

import com.example.shopteamvoy.dao.ShopDao;
import com.example.shopteamvoy.dto.request.ProductRequest;
import com.example.shopteamvoy.dto.response.ProductResponse;
import com.example.shopteamvoy.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements RequestDtoMapper<Product, ProductRequest>,
        ResponseDtoMapper<Product, ProductResponse> {
    private final ShopDao shopDao;

    public ProductMapper(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Override
    public Product mapToModel(ProductRequest dto) {
        Product product = new Product();
        product.setCount(dto.getCount());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setShop(shopDao.getById(dto.getShopId()));
        return product;
    }

    @Override
    public ProductResponse mapToDto(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setCount(product.getCount());
        response.setShopId(product.getShop().getId());
        return response;
    }
}
