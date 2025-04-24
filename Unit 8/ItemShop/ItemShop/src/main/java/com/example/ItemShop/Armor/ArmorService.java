package com.example.ItemShop.Armor;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArmorService {
    private final ArmorRepository armorRepository;

    public ArmorService(ArmorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }

    public List<Armor> getArmor() { return armorRepository.findAll(); }

    public Optional<Armor> getSingleArmorInfo(String armorName) {
        Optional<Armor> armorByName = armorRepository.findByName(armorName);
        if (armorByName.isPresent()) {
            return armorRepository.findByName(armorName);
        }
        throw new IllegalStateException("Armor not found");
    }

    public void addNewArmor(Armor armor) {
        Optional<Armor> armorByName = armorRepository.findByName(armor.getName());
        armor.getDescription();

        if (armorByName.isPresent()) {
            throw new IllegalStateException("Armor with name " + armor.getName() + " already exists");
        }
        armorRepository.save(armor);
        System.out.println(armor);
    }

    public void deleteArmor(Long armorId) {
            boolean exists = armorRepository.existsById(armorId);
        if (!exists) {
            throw new IllegalStateException("Armor with id " + armorId + " does not exist");
        }
        armorRepository.deleteById(armorId);
    }

    @Transactional
    public void updateArmor(Long armorId, String name) {
        Armor armor = armorRepository.findById(armorId).orElseThrow(() -> new IllegalStateException("Armor with id " + armorId + " does not exist"));

        if (name != null && !name.isEmpty() && !Objects.equals(armor.getName(), name)) {
            Optional<Armor> armorByName = armorRepository.findByName(name);
            if (armorByName.isPresent()) {
                throw new IllegalStateException("Armor with name " + name + " already exists");
            }
            armor.setName(name);
        }
    }
}
