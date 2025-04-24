package com.example.ItemShop.Weapon;

import com.example.ItemShop.Seller.Seller;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public Long getId() {
        return id;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "sellerWeapons")
    private Set<Seller> sellers = new HashSet<>();

    public Weapon() {
    }

    public Weapon(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void addSellertoWeapon(Seller seller) {
        sellers.add(seller);
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    public void removeSellerfromWeapon(Seller seller) {
        sellers.remove(seller);
    }
}
