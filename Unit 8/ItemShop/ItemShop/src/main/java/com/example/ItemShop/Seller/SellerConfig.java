package com.example.ItemShop.Seller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SellerConfig {
    @Bean
        CommandLineRunner SellercommandLineRunner(SellerRepository repository) {
            return args -> {
                Seller seller1 = new Seller("Skuncl McQueen");

                Seller seller2 = new Seller("Krincl McKing");

                repository.saveAll(List.of(seller1, seller2));
            };
        }
}
