package com.example.ItemShop.Armor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ArmorConfig {

    @Bean
    CommandLineRunner ArmorcommandLineRunner(ArmorRepository repository) {
        return args -> {
            Armor armor1 = new Armor("Basic Chain Mail", "Regular Chain Mail. It's not even good. Don't buy this. Please.");

            Armor armor2 = new Armor("Divine Hero's Dentures", "Legendary Dentures worn by the divine hero.");

            repository.saveAll(List.of(armor1, armor2));
        };
    }
}
