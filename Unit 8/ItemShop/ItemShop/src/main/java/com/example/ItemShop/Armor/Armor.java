package com.example.ItemShop.Armor;

import com.example.ItemShop.Seller.Seller;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Armor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "sellerArmor")
    private Set<Seller> sellers = new HashSet<>();

    public Armor() {

    }

    public Armor(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public Armor(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Set<Seller> getSellers() {
        return sellers;
    }

    public void addSellertoArmor(Seller seller) {
        sellers.add(seller);
    }

    public void removeSellerfromArmor(Seller seller) {
        sellers.remove(seller);
    }
}
