package bg.softuni.books.web;

import bg.softuni.books.models.Book;
import bg.softuni.books.models.dtos.BookDto;
import bg.softuni.books.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;
    private final ModelMapper mapper;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.mapper = new ModelMapper();
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        BookDto[] map = mapper.map(bookRepository.findAll(), BookDto[].class);

        return ResponseEntity.ok(map);
    }
}
