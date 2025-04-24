package com.example.ItemShop.Armor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/armor")
public class ArmorController {
    private final ArmorService armorService;

    @Autowired
    ArmorRepository armorRepository;

    public ArmorController(ArmorService armorService) {
        this.armorService = armorService;
    }

    @GetMapping
    List<Armor> getArmor() { return armorRepository.findAll(); }

    @GetMapping("/{armorName}")
    Optional<Armor> getSingleArmorInfo(@PathVariable String armorName) { return armorService.getSingleArmorInfo(armorName); }

    @PostMapping
    public void createArmor(@RequestBody Armor armor) { armorService.addNewArmor(armor); }

    @DeleteMapping(path = "/deleteArmor/{armor}")
    public void deleteArmor(@PathVariable Long armor) { armorService.deleteArmor(armor); }
}
