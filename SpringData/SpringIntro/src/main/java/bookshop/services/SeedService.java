package bookshop.services;

import java.io.IOException;

public interface SeedService {
    void seedCategories() throws IOException;
    void seedAuthors() throws IOException;
    void seedBooks() throws IOException;
    default void seedAll() throws IOException {
        seedAuthors();
        seedCategories();
        seedBooks();
    }
}
