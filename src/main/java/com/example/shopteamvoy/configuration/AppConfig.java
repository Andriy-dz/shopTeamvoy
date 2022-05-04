package com.example.shopteamvoy.configuration;

import com.example.shopteamvoy.service.OrderService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class AppConfig {
    private final OrderService orderService;

    public AppConfig(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(cron = "0 */10 * * * *")
    public void orderControl() {
        orderService.deleteOverdue();
    }
}
