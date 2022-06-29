package bg.softuni.books.repositories;

import bg.softuni.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
}
