package com.example.ItemShop.Seller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {this.sellerRepository = sellerRepository;}

    public List<Seller> getSellers() { return sellerRepository.findAll(); }

    public Optional<Seller> getSingleSellerInfo(String sellerName) {
        Optional<Seller> sellerByName = sellerRepository.findByName(sellerName);
        if (sellerByName.isPresent()) {
            return sellerRepository.findByName(sellerName);
        }
        throw new IllegalStateException("Seller not found");
    }

    public void addNewSeller(Seller seller) {
        Optional<Seller> sellerByName = sellerRepository.findByName(seller.getName());

        if (sellerByName.isPresent()) {
            throw new IllegalStateException("Seller with name " + seller.getName() + " already exists");
        }
        sellerRepository.save(seller);
        System.out.println(seller);
    }

    public void deleteSeller(Long sellerId) {
        boolean exists = sellerRepository.existsById(sellerId);
        if (!exists) {
            throw new IllegalStateException("Seller with id " + sellerId + " does not exist");
        }
        sellerRepository.deleteById(sellerId);
    }

    @Transactional
    public void updateSeller(Long sellerId, String name) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(() -> new IllegalStateException("Seller with id " + sellerId + " does not exist"));

        if (name != null && !name.isEmpty() && !Objects.equals(seller.getName(), name)) {
            Optional<Seller> sellerByName = sellerRepository.findByName(name);
            if (sellerByName.isPresent()) {
                throw new IllegalStateException("Seller with name " + name + " already exists");
            }
            seller.setName(name);
        }
    }
}