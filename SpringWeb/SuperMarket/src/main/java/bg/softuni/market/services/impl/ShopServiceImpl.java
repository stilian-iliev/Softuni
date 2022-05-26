package bg.softuni.market.services.impl;

import bg.softuni.market.models.entities.Shop;
import bg.softuni.market.models.entities.Town;
import bg.softuni.market.repositories.ShopRepository;
import bg.softuni.market.repositories.TownRepository;
import bg.softuni.market.services.ShopService;
import bg.softuni.market.utils.InvalidArgumentException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
    private TownRepository townRepository;
    private ShopRepository shopRepository;

    public ShopServiceImpl(TownRepository townRepository, ShopRepository shopRepository) {
        this.townRepository = townRepository;
        this.shopRepository = shopRepository;
    }


    @Override
    public void addShop(String name, String address, String town) {
        Optional<Town> optionalTown = townRepository.findByName(town);
        Optional<Shop> optionalShop = shopRepository.findByAddress(address);
        if (optionalTown.isEmpty()) throw new InvalidArgumentException("No such town!");
        if (optionalShop.isPresent()) throw new InvalidArgumentException("There is a shop on this address already!");
        shopRepository.save(new Shop(name, address, optionalTown.get()));
        System.out.println("Successfully added shop!");
    }

    @Transactional
    @Override
    public void showAllSellers(String name) {
        Optional<Shop> optionalShop = shopRepository.findByName(name);
        if (optionalShop.isEmpty()) throw new InvalidArgumentException("No such shop!");
        optionalShop.get().getSellers().forEach(System.out::println);
    }

    @Transactional
    @Override
    public void showAllProducts(String name) {
        Optional<Shop> optionalShop = shopRepository.findByName(name);
        if (optionalShop.isEmpty()) throw new InvalidArgumentException("No such shop!");
        optionalShop.get().getProducts().forEach(System.out::println);
    }
}
