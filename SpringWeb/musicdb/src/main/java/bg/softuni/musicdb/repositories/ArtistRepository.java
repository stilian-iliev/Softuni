package bg.softuni.musicdb.repositories;

import bg.softuni.musicdb.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    boolean existsByName(String value);

    Optional<Artist> findByName(String artist);
}
