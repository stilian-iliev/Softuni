package bookshop;

import bookshop.models.Author;
import bookshop.models.Book;
import bookshop.repositories.AuthorRepository;
import bookshop.repositories.BookRepository;
import bookshop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final SeedService seedService;

    @Autowired
    public ConsoleRunner(AuthorRepository authorRepository, BookRepository bookRepository, SeedService seedService) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {
//        findAfter2000();
//        findWithBookBefore1990();
//        findAllOrderedByBooksCount();
        findByAuthorOrdered();
    }

    private void findByAuthorOrdered() {
        List<Book> books = bookRepository.findByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitle("George", "Powell");
        books.forEach(b -> System.out.printf("%s - %s - %d%n", b.getTitle(), b.getReleaseDate(), b.getCopies()));
    }


    private void findAllOrderedByBooksCount() {
        List<Author> authors = authorRepository.findAll();
        authors.sort((a,b)-> b.getBooks().size() - a.getBooks().size());

        authors.forEach(a -> System.out.printf("%s %s - %d%n", a.getFirstName(), a.getLastName(), a.getBooks().size()));

    }


    private void findWithBookBefore1990() {
        List<Author> authors = authorRepository.findDistinctByBooksReleaseDateBefore(LocalDate.of(1990, 1, 1));
        authors.stream().map(a-> a.getFirstName() + " " + a.getLastName()).forEach(System.out::println);
    }

    private void findAfter2000() {
        List<Book> books = bookRepository.findByReleaseDateAfter(LocalDate.of(2000, 1, 1));
        books.stream().map(Book::getTitle).forEach(System.out::println);
    }
}
