package com.example.ItemShop.Seller;

import com.example.ItemShop.Armor.Armor;
import com.example.ItemShop.Shop.Shop;
import com.example.ItemShop.Weapon.Weapon;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    public Long getId() {
        return id;
    }

    @ManyToMany
    @JoinTable(
            name="weapon_added",
            joinColumns = @JoinColumn(name="seller_id"),
            inverseJoinColumns = @JoinColumn(name="weapon_id")
    )
    private Set<Weapon> sellerWeapons = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="armor_added",
            joinColumns = @JoinColumn(name="seller_id"),
            inverseJoinColumns = @JoinColumn(name="armor_id")
    )
    private Set<Armor> sellerArmor = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;

    public Seller() {
    }

    public Seller(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seller(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addArmortoSeller(Armor armor) {
        sellerArmor.add(armor);
    }

    public Set<Armor> getSellerArmor() {
        return sellerArmor;
    }

    public void addWeapontoSeller(Weapon weapon) {
        sellerWeapons.add(weapon);
    }

    public Set<Weapon> getSellerWeapons() {
        return sellerWeapons;
    }

    public Shop getShop() {
        return shop;
    }

    public void removeArmorfromSeller(Armor armor) {
        sellerArmor.remove(armor);
    }

    public void removeWeaponfromSeller(Weapon weapon) {
        sellerWeapons.remove(weapon);
    }

    public void assignShop(Shop shop) {
        this.shop = shop;
    }
}
