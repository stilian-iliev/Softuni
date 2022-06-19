package bookshop.services;

import bookshop.models.Author;
import bookshop.models.Book;
import bookshop.models.Category;
import bookshop.models.enumerations.AgeRestriction;
import bookshop.models.enumerations.EditionType;
import bookshop.repositories.AuthorRepository;
import bookshop.repositories.BookRepository;
import bookshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SeedServiceImpl implements SeedService{

    private final String RESOURCE_PATH = "src\\main\\resources\\files";
    private final String AUTHORS_FILE_PATH = RESOURCE_PATH + "\\authors.txt";
    private final String CATEGORIES_FILE_PATH = RESOURCE_PATH + "\\categories.txt";
    private final String BOOKS_FILE_PATH = RESOURCE_PATH + "\\books.txt";

    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public SeedServiceImpl(AuthorRepository authorRepository, CategoryRepository categoryRepository, BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH))
                .stream().filter(s -> !s.isBlank())
                .forEach(c-> categoryRepository.save(new Category(c)));
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_FILE_PATH))
                .stream().filter(s -> !s.isBlank())
                .map(s -> s.split("\\s+"))
                .map(names -> new Author(names[0], names[1]))
                .forEach(authorRepository::save);
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(BOOKS_FILE_PATH))
                .stream().filter(s -> !s.isBlank())
                .map(s -> s.split("\\s+"))
                .map(this::createBook)
                .forEach(bookRepository::save);
    }

    public Book createBook(String[] info) {
        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();

        EditionType editionType = EditionType.values()[Integer.parseInt(info[0])];

        LocalDate releaseDate = LocalDate.parse(info[1],
                DateTimeFormatter.ofPattern("d/M/yyyy"));

        int copies = Integer.parseInt(info[2]);

        BigDecimal price = new BigDecimal(info[3]);

        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(info[4])];

        String title = Arrays.stream(info)
                .skip(5)
                .collect(Collectors.joining(" "));

        return new Book(title, editionType, price, releaseDate, ageRestriction, author, categories, copies);
    }
}
