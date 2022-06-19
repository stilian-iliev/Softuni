package shampoosDB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shampoosDB.entities.Shampoo;
import shampoosDB.entities.Size;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySize(Size size);
    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, Long id);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    Long countByPriceLessThan(BigDecimal price);

//    @Query("select distinct s from Shampoo s" +
//            " join s.ingredients i" +
//            " where i.name in :names"
//    )
    List<Shampoo> findAllDistinctByIngredientsNameIn(List<String> names);

    @Query("select s from Shampoo s" +
            " where s.ingredients.size < :size")
    List<Shampoo> findAllWithIngredientsCountLessThan(int size);
}
