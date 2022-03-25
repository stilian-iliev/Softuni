package xml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xml.entities.user.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u order by u.lastName, u.firstName")
    List<User> findAllOrderByLastNameAscFirstNameAsc();
}
