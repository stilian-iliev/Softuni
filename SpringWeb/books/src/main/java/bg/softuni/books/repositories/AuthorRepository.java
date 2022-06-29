package bg.softuni.books.repositories;

import bg.softuni.books.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByName(String authorName);

    Author findByName(String authorName);
}
