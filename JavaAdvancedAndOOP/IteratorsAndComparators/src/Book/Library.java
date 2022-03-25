package Book;

import java.util.Iterator;

public class Library implements Iterable<Book>{

    private Book[] books;

    public Library(Book... books){
        this.books = books;
    }

    public Iterator<Book> iterator(){
        return new Iterator<>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index< books.length;
            }

            @Override
            public Book next() {
                return books[index++];
            }
        };
    }
}