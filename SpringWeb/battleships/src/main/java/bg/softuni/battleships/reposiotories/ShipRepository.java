package bg.softuni.battleships.reposiotories;

import bg.softuni.battleships.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    Optional<Ship> findByName(String value);
}
