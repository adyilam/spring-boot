package books.service;

import books.domain.Book;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface BookService {

    void addBook(Book book);

    void updateBook(Book book);

    Book getBook(String isbn);

    boolean deleteBook(String isbn);

    Collection<Book> getAllBooks();
}
