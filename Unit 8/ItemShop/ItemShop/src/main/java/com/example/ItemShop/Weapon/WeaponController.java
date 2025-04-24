package com.example.ItemShop.Weapon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/weapons")
public class WeaponController {
    private final WeaponService weaponService;

    @Autowired
    WeaponRepository weaponRepository;

    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping
    List<Weapon> getWeapons() { return weaponRepository.findAll(); }

    @GetMapping("/{weaponName}")
    Optional<Weapon> getSingleWeaponInfo(@PathVariable String weaponName) { return weaponService.getSingleWeaponInfo(weaponName); }

    @PostMapping
    public void createWeapon(@RequestBody Weapon weapon) { weaponService.addNewWeapon(weapon); }

    @DeleteMapping(path = "/deleteWeapon/{weapon}")
    public void deleteWeapon(@PathVariable Long weapon) { weaponService.deleteWeapon(weapon); }
}
