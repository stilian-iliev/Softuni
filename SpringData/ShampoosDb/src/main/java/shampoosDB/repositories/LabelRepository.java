package shampoosDB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shampoosDB.entities.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
}
