package com.example.ItemShop.Weapon;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WeaponService {
    private final WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {this.weaponRepository = weaponRepository;}

    public Optional<Weapon> getSingleWeaponInfo(String weaponName) {
        Optional<Weapon> weaponByName = weaponRepository.findByName(weaponName);
        if (weaponByName.isPresent()) {
            return weaponRepository.findByName(weaponName);
        }
        throw new IllegalStateException("Weapon not found");
    }

    public void addNewWeapon(Weapon weapon) {
        Optional<Weapon> weaponByName = weaponRepository.findByName(weapon.getName());
        weapon.getDescription();

        if (weaponByName.isPresent()) {
            throw new IllegalStateException("Weapon with name " + weapon.getName() + " already exists");
        }
        weaponRepository.save(weapon);
        System.out.println(weapon);
    }

    public void deleteWeapon(Long weaponId) {
        boolean exists = weaponRepository.existsById(weaponId);
        if (!exists) {
            throw new IllegalStateException("Weapon with id " + weaponId + " does not exist");
        }
        weaponRepository.deleteById(weaponId);
    }

    @Transactional
    public void updateWeapon(Long weaponId, String name) {
        Weapon weapon = weaponRepository.findById(weaponId).orElseThrow(() -> new IllegalStateException("Weapon with id " + weaponId + " does not exist"));

        if (name != null && !name.isEmpty() && !Objects.equals(weapon.getName(), name)) {
            Optional<Weapon> weaponByName = weaponRepository.findByName(name);
            if (weaponByName.isPresent()) {
                throw new IllegalStateException("Weapon with name " + name + " already exists");
            }
            weapon.setName(name);
        }
    }
}
