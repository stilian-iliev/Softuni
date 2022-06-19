package bookshop_exercise.service;

import bookshop_exercise.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    void printAllAuthorsFirstNamesStartingWith(String endsWith);

    void printAllBookCopies();

    void printBooksCountByName(String name);
}
