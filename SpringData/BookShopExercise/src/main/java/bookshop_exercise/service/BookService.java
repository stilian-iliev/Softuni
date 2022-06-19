package bookshop_exercise.service;

import bookshop_exercise.entity.AgeRestriction;
import bookshop_exercise.entity.Book;
import bookshop_exercise.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    void printAllTitlesWithAgeRestriction(AgeRestriction ageRestriction);

    void printAllTitlesByEditionAndLessThanCopies(EditionType editionType, int copies);

    void printTitleAndPriceWithPriceNotBetween(BigDecimal low, BigDecimal high);

    void printTitlesWhereYearNot(int year);

    void printBooksBeforeDate(LocalDate date);

    void printAllTitlesContainingSubstr(String subStr);

    void printTitlesOfAuthorsStartingWith(String startingWith);

    void printCountOfBooksWhoseTitleLongerThan(int n);

    void printBookSummary(String bookTitle);

    void increaseCopiesOfBooksAfterDate(int amount, LocalDate date);

    void deleteBooksWithCopiesLessThan(int threshold);
}
