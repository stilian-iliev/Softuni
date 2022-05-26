package bg.softuni.market.services.impl;

import bg.softuni.market.models.entities.Category;
import bg.softuni.market.models.entities.Product;
import bg.softuni.market.models.entities.Shop;
import bg.softuni.market.repositories.CategoryRepository;
import bg.softuni.market.repositories.ProductRepository;
import bg.softuni.market.repositories.ShopRepository;
import bg.softuni.market.services.ProductService;
import bg.softuni.market.utils.InvalidArgumentException;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ShopRepository shopRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ShopRepository shopRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    public void addProduct(String name, BigDecimal price, LocalDate bestBefore, String category) {
        Optional<Category> optionalCategory = categoryRepository.findByName(category);
        if (optionalCategory.isEmpty()) throw new InvalidArgumentException("No such category!");
        productRepository.save(new Product(name, price, bestBefore, optionalCategory.get()));
        System.out.println("Successfully added product!");
    }

    @Override
    public void distributeProduct(String name, String... shops) {
        Optional<Product> optionalProduct = productRepository.findByName(name);
        if (optionalProduct.isEmpty()) throw new InvalidArgumentException("No such product!");
        for (String shop : shops) {
            Optional<Shop> optionalShop = shopRepository.findByName(shop);
            if (optionalShop.isEmpty()) throw new InvalidArgumentException("No such shop " + shop);
            optionalShop.get().addProduct(optionalProduct.get());
            shopRepository.save(optionalShop.get());
        }
        System.out.println("Successfully added product distribution!");
    }
}
