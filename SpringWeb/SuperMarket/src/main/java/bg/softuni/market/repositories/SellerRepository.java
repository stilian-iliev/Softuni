package bg.softuni.market.repositories;

import bg.softuni.market.models.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByFirstNameAndLastName(String firstName, String lastName);
}
