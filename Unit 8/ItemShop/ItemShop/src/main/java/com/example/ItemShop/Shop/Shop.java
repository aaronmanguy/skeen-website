package com.example.ItemShop.Shop;

import com.example.ItemShop.Seller.Seller;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "shop")
    private Set<Seller> sellers = new HashSet<>();

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public Shop() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Seller> getSellers() {
        return sellers;
    }
}
