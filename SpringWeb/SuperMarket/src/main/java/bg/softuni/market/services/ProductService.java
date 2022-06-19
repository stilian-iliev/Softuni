package bg.softuni.market.services;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ProductService {
    void addProduct(String name, BigDecimal price, LocalDate bestBefore, String category);

    void distributeProduct(String name, String... shops);
}
