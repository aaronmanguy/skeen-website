package com.example.ItemShop.Seller;

import com.example.ItemShop.Armor.Armor;
import com.example.ItemShop.Armor.ArmorRepository;
import com.example.ItemShop.Shop.Shop;
import com.example.ItemShop.Shop.ShopRepository;
import com.example.ItemShop.Weapon.Weapon;
import com.example.ItemShop.Weapon.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    private final SellerService sellerService;
    private final SellerRepository sellerRepository;
    private final ArmorRepository armorRepository;
    private final WeaponRepository weaponRepository;
    private final ShopRepository shopRepository;

    @Autowired
    public SellerController (SellerService sellerService, SellerRepository sellerRepository, ArmorRepository armorRepository, WeaponRepository weaponRepository, ShopRepository shopRepository) {this.sellerService = sellerService;
        this.sellerRepository = sellerRepository;
        this.armorRepository = armorRepository;
        this.weaponRepository = weaponRepository;
        this.shopRepository = shopRepository;
    }

    @GetMapping
    public List<Seller> getSellers() { return sellerService.getSellers(); }

    @GetMapping("/{sellerName}")
    Optional<Seller> getSingleSeller(@PathVariable String sellerName) { return sellerService.getSingleSellerInfo(sellerName); }

    @PostMapping
    public void createSeller(@RequestBody Seller seller) { sellerService.addNewSeller(seller); }

    @DeleteMapping(path = "/deleteSeller/{sellerId}")
    public void deleteSeller(@PathVariable Long sellerId) { sellerService.deleteSeller(sellerId); }

    @PutMapping("/{sellerId}/{itemType}/{itemId}")
    Seller addItemtoSeller(
            @PathVariable Long sellerId,
            @PathVariable String itemType,
            @PathVariable Long itemId
    ) {
        Seller seller = sellerRepository.findById(sellerId).get();
        if(itemType.equals("armor")) {
            Armor armor = armorRepository.findById(itemId).get();
            seller.addArmortoSeller(armor);
        }
        if(itemType.equals("weapon")) {
            Weapon weapon = weaponRepository.findById(itemId).get();
            weapon.addSellertoWeapon(seller);
            seller.addWeapontoSeller(weapon);
        }
        return sellerRepository.save(seller);
    }

    @PutMapping("/{sellerId}/removeItem/{itemType}/{itemId}")
    Seller removeItemfromSeller(
            @PathVariable Long sellerId,
            @PathVariable String itemType,
            @PathVariable Long itemId
    ) {
        Seller seller = sellerRepository.findById(sellerId).get();
        if(itemType.equals("armor")) {
            Armor armor = armorRepository.findById(itemId).get();
            seller.removeArmorfromSeller(armor);
        }
        if(itemType.equals("weapon")) {
            Weapon weapon = weaponRepository.findById(itemId).get();
            weapon.removeSellerfromWeapon(seller);
            seller.removeWeaponfromSeller(weapon);
        }
        return sellerRepository.save(seller);
    }

    @PutMapping("/{sellerId}/shop/{shopId}")
    Seller assignSellerToShop(
            @PathVariable Long sellerId,
            @PathVariable Long shopId
    ) {
        Seller seller = sellerRepository.findById(sellerId).get();
        Shop shop = shopRepository.findById(shopId).get();

        seller.assignShop(shop);

        return sellerRepository.save(seller);
    }
}
