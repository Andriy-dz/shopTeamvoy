package com.example.shopteamvoy.service.impl;

import com.example.shopteamvoy.dao.OrderDao;
import com.example.shopteamvoy.model.Order;
import com.example.shopteamvoy.model.Product;
import com.example.shopteamvoy.service.OrderService;
import com.example.shopteamvoy.service.ProductService;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao dao;
    private final ProductService productService;

    public OrderServiceImpl(OrderDao dao, ProductService productService) {
        this.dao = dao;
        this.productService = productService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Order add(Order order) {
        Product product = order.getProduct();
        if (product.getCount() < order.getCount()) {
            order.setCount(product.getCount());
            order.setSum(order.getCount() * product.getPrice());
            product.setCount(0.0);
        } else {
            product.setCount(product.getCount() - order.getCount());
        }
        productService.update(product);
        return dao.save(order);
    }

    @Override
    public Order get(Long id) {
        return dao.getById(id);
    }

    @Override
    public Order confirm(Long id) {
        Order order = dao.getById(id);
        order.setBought(true);
        return dao.save(order);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOverdue() {
        dao.findAllOverdue(LocalDateTime.now().minusMinutes(10)).stream()
                .peek(order -> {
                    Product product = order.getProduct();
                    product.setCount(product.getCount() + order.getCount());
                    productService.update(product);
                    delete(order.getId());
                }).collect(Collectors.toList());
    }
}
