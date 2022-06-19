package bg.softuni.market.services.impl;

import bg.softuni.market.models.entities.Seller;
import bg.softuni.market.models.entities.Shop;
import bg.softuni.market.repositories.SellerRepository;
import bg.softuni.market.repositories.ShopRepository;
import bg.softuni.market.services.SellerService;
import bg.softuni.market.utils.InvalidArgumentException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    private final ShopRepository shopRepository;
    private final SellerRepository sellerRepository;

    public SellerServiceImpl(ShopRepository shopRepository, SellerRepository sellerRepository) {
        this.shopRepository = shopRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void addSeller(String firstName, String lastName, int age, BigDecimal salary, String shopName) {
        Optional<Shop> optionalShop = shopRepository.findByName(shopName);
        if (optionalShop.isEmpty()) throw new InvalidArgumentException("No such shop!");
        sellerRepository.save(new Seller(firstName, lastName, age, salary, optionalShop.get()));
        System.out.println("Successfully added seller!");
    }

    @Override
    public void setNewManager(String sellerFirstName, String sellerLastName, String managerFirstName, String managerLastName) {
        Optional<Seller> optionalSeller = sellerRepository.findByFirstNameAndLastName(sellerFirstName, sellerLastName);
        if (optionalSeller.isEmpty()) throw new InvalidArgumentException("No such seller!");
        Optional<Seller> optionalManager = sellerRepository.findByFirstNameAndLastName(sellerFirstName, sellerLastName);
        if (optionalManager.isEmpty()) throw new InvalidArgumentException("No such manager!");
        optionalSeller.get().setManager(optionalManager.get());
        System.out.println("Successfully added manager!");
    }


}
