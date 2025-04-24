package com.example.ItemShop.Armor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArmorRepository extends JpaRepository<Armor, Long> {
    Optional<Armor> findByName(String armorName);
}
