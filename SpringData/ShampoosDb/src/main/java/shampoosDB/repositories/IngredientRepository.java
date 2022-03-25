package shampoosDB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shampoosDB.entities.Ingredient;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String firstLetter);

    List<Ingredient> findAllByNameInOrderByPrice(List<String> ingredientNames);

    int deleteByName(String name);

    @Modifying
@Transactional
    @Query("update Ingredient i set i.price = i.price * 1.1")
    int increasePriceByTenPercent();

    @Modifying
    @Transactional
    @Query("update Ingredient i set i.price = i.price * (1 + (:percentage / 100)) where i.name in :names")
    int increasePriceInNames(List<String> names, double percentage);
}
