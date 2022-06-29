package bg.softuni.books.web;

import bg.softuni.books.models.Author;
import bg.softuni.books.models.Book;
import bg.softuni.books.models.dtos.AddBookDto;
import bg.softuni.books.models.dtos.BookDto;
import bg.softuni.books.repositories.AuthorRepository;
import bg.softuni.books.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapper mapper;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.mapper = new ModelMapper();
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        BookDto[] map = mapper.map(bookRepository.findAll(), BookDto[].class);

        return ResponseEntity.ok(map);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") Long id) {
        BookDto book = mapper.map(bookRepository.findById(id), BookDto.class);

        return ResponseEntity.ok(book);
    }


    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody AddBookDto addBookDto) {
        if (!authorRepository.existsByName(addBookDto.getAuthorName())) {
            authorRepository.save(new Author(addBookDto.getAuthorName()));
        }
        Author author = authorRepository.findByName(addBookDto.getAuthorName());
        bookRepository.save(new Book(addBookDto.getTitle(), addBookDto.getIsbn(), author));
        Long id = bookRepository.findByIsbn(addBookDto.getIsbn()).getId();
        return ResponseEntity.created(URI.create("http://localhost:8080/api/books/"+id)).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
