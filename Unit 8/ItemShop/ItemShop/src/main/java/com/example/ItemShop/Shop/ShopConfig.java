package com.example.ItemShop.Shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShopConfig {
    @Bean
    public CommandLineRunner commandLineRunner(ShopRepository repository) {
        return args -> {
            Shop shop = new Shop("Horse Knuckle Auction House");

            repository.saveAll(List.of(shop));
        };
    }
}
