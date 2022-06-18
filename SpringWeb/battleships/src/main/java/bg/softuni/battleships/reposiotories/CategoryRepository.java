package bg.softuni.battleships.reposiotories;

import bg.softuni.battleships.models.Category;
import bg.softuni.battleships.models.enums.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(ShipType name);
}
