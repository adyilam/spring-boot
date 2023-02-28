package books.data;

import books.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {

    private Map<String, Book> books = new HashMap<>();

    public void save(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book findBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public void delete(String isbn) {
        books.remove(isbn);
    }

    public Collection<Book> findAll() {
        return books.values();
    }
}
