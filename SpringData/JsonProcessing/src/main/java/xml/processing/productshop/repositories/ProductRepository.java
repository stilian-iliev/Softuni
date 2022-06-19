package xml.processing.productshop.repositories;

import xml.processing.productshop.entities.product.Product;
import xml.processing.productshop.entities.product.SellableProductsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<SellableProductsDto> findAllByBuyerNullAndPriceBetweenOrderByPriceAsc(BigDecimal low, BigDecimal high);

}
