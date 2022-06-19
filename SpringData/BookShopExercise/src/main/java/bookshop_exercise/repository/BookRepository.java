package bookshop_exercise.repository;

import bookshop_exercise.entity.AgeRestriction;
import bookshop_exercise.entity.Book;
import bookshop_exercise.entity.BookSummary;
import bookshop_exercise.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal low, BigDecimal high);

    @Query("from Book b where year(b.releaseDate) != :year")
    List<Book> findAllByReleaseDateYearNot(int year);

    List<Book> findAllByTitleContainingIgnoreCase(String subStr);

    List<Book> findAllByAuthorLastNameStartingWith(String startingWith);

    @Query("select count(b) from Book b where length(b.title) > :n")
    int countByTitleLongerThan(int n);

    @Query("select title as title, editionType as editionType, ageRestriction as ageRestriction, price as price from Book where title = :title")
    BookSummary findBookSummaryByTitle(String title);

    @Modifying
    @Transactional
    @Query("update Book set copies = copies + :amount where releaseDate > :date")
    int increaseCopiesByDateAfter(LocalDate date, int amount);

    @Transactional
    @Modifying
    int deleteByCopiesLessThan(int threshold);
}
