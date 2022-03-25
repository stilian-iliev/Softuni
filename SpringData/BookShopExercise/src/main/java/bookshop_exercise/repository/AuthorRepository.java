package bookshop_exercise.repository;

import bookshop_exercise.entity.Author;
import bookshop_exercise.entity.AuthorBooksCopies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findAllByFirstNameEndsWith(String endsWith);

    @Query("select concat(a.firstName, ' ', a.lastName) as fullName, sum(b.copies) as booksCopies from Author a join a.books b group by b.author order by booksCopies desc")
    List<AuthorBooksCopies> findAllAuthorsAndBookCopies();

    @Procedure("udp_get_books_count_from_author")
    int findCountOfBooksByFirstNameAndLastName(String firstName, String lastName);
}
