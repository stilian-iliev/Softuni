package xml.processing.productshop.repositories;

import xml.processing.productshop.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u join u.soldProducts p where p.buyer is not null")
    List<User> findAllWithSoldItems();

    @Query("select u from User u")
    List<User> findAllUsersAndProducts();
}
