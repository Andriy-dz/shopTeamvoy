package com.example.shopteamvoy.controller;

import com.example.shopteamvoy.model.Basket;
import com.example.shopteamvoy.model.Product;
import com.example.shopteamvoy.model.Shop;
import com.example.shopteamvoy.model.User;
import com.example.shopteamvoy.service.BasketService;
import com.example.shopteamvoy.service.OrderService;
import com.example.shopteamvoy.service.ProductService;
import com.example.shopteamvoy.service.ShopService;
import com.example.shopteamvoy.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/injector")
public class InjectorController {
    private final UserService userService;
    private final ShopService shopService;
    private final BasketService basketService;
    private final ProductService productService;
    private final OrderService orderService;

    public InjectorController(UserService userService,
                              ShopService shopService,
                              BasketService basketService,
                              ProductService productService,
                              OrderService orderService) {
        this.userService = userService;
        this.shopService = shopService;
        this.basketService = basketService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @PostMapping
    public void inject() {
        Shop shop = new Shop();
        shop.setName("Shop");
        shopService.add(shop);

        Product apple = new Product();
        apple.setShop(shop);
        apple.setName("Apple");
        apple.setPrice(10.0);
        apple.setCount(20.0);
        Product apple2 = new Product();
        apple2.setShop(shop);
        apple2.setName("Apple");
        apple2.setPrice(11.0);
        apple2.setCount(20.0);
        Product product2 = new Product();
        product2.setShop(shop);
        product2.setName("Banana");
        product2.setPrice(15.0);
        product2.setCount(9.0);
        productService.add(apple);
        productService.add(apple2);
        productService.add(product2);

        User user1 = new User();
        user1.setName("User1");
        User user2 = new User();
        user2.setName("User2");
        userService.add(user1);
        userService.add(user2);

        Basket basket1 = new Basket();
        basket1.setUser(user1);
        Basket basket2 = new Basket();
        basket2.setUser(user2);
        basketService.add(basket1);
        basketService.add(basket2);

    }
}
