package bookshop_exercise.service.impl;

import bookshop_exercise.entity.*;
import bookshop_exercise.repository.BookRepository;
import bookshop_exercise.service.AuthorService;
import bookshop_exercise.service.BookService;
import bookshop_exercise.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public void printAllTitlesWithAgeRestriction(AgeRestriction ageRestriction) {
        bookRepository.findAllByAgeRestriction(ageRestriction)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);
    }

    @Override
    public void printAllTitlesByEditionAndLessThanCopies(EditionType editionType, int copies) {
        bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, copies)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);
    }

    @Override
    public void printTitleAndPriceWithPriceNotBetween(BigDecimal low, BigDecimal high) {
        bookRepository.findAllByPriceLessThanOrPriceGreaterThan(low, high)
                .stream().map(e -> String.format("%s - $%.2f", e.getTitle(), e.getPrice()))
                .forEach(System.out::println);
    }

    @Override
    public void printTitlesWhereYearNot(int year) {
        bookRepository.findAllByReleaseDateYearNot(year)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);
    }

    @Override
    public void printBooksBeforeDate(LocalDate date) {
        bookRepository.findAllByReleaseDateBefore(date)
                .stream().map(e -> String.format("%s %s %.2f", e.getTitle(), e.getEditionType(), e.getPrice()))
                .forEach(System.out::println);
    }

    @Override
    public void printAllTitlesContainingSubstr(String subStr) {
        bookRepository.findAllByTitleContainingIgnoreCase(subStr)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);
    }

    @Override
    public void printTitlesOfAuthorsStartingWith(String startingWith) {
        bookRepository.findAllByAuthorLastNameStartingWith(startingWith)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);
    }

    @Override
    public void printCountOfBooksWhoseTitleLongerThan(int n) {
        System.out.println(bookRepository.countByTitleLongerThan(n));
    }

    @Override
    public void printBookSummary(String bookTitle) {
        BookSummary bookSummary = bookRepository.findBookSummaryByTitle(bookTitle);
        System.out.printf("%s %s %s %.2f%n", bookSummary.getTitle(), bookSummary.getEditionType(), bookSummary.getAgeRestriction(), bookSummary.getPrice());
    }

    @Override
    public void increaseCopiesOfBooksAfterDate(int amount, LocalDate date) {
        int updated = bookRepository.increaseCopiesByDateAfter(date, amount);
        System.out.println(updated*amount);
    }

    @Override
    public void deleteBooksWithCopiesLessThan(int threshold) {
        System.out.println(bookRepository.deleteByCopiesLessThan(threshold));
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
