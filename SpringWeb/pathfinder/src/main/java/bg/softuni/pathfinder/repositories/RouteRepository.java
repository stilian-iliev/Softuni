package bg.softuni.pathfinder.repositories;

import bg.softuni.pathfinder.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query("select r from Route r order by size(r.comments) desc")
    List<Route> findRoutesOrderedByCommentsSize();
}
