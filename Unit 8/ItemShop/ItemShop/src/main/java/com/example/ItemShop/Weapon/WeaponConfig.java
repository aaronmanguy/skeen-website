package com.example.ItemShop.Weapon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WeaponConfig {
    @Bean
    CommandLineRunner WeaponcommandLineRunner(WeaponRepository repository) {
        return args -> {
            Weapon weapon1 = new Weapon("Basic Iron Sword", "A regular Iron Sword. It's not even good. Don't buy this. Please.");

            Weapon weapon2 = new Weapon("Divine Hero's Cane", "A Legendary Cane wielded by the divine hero.");

            repository.saveAll(List.of(weapon1, weapon2));
        };
    }
}
