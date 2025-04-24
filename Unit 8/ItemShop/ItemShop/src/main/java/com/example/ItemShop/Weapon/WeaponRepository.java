package com.example.ItemShop.Weapon;

import com.example.ItemShop.Seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface WeaponRepository extends JpaRepository<Weapon, Long> {
    Optional<Weapon> findByName(String name);
}
