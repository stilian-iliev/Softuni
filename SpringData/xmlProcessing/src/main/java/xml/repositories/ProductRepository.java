package xml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xml.entities.product.Product;
import xml.entities.product.ProductsInRangeDto;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select new xml.entities.product.ProductsInRangeDto(p.name, p.price, s.firstName, s.lastName) from Product p join p.seller s where (p.price between :low and :high) and p.buyer is null order by p.price")
    List<ProductsInRangeDto> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high);

}
