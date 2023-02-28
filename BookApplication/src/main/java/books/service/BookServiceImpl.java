package books.service;

import books.data.BookRepository;
import books.domain.Book;
import books.integration.JmsSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    JmsSender jmsSender;

    @Override
    public void addBook(Book book) {
        log.info("Inside addBook {}");
        bookRepository.save(book);
        jmsSender.sendMessage(book);
    }

    @Override
    public void updateBook(Book book) {
        log.info("Inside updateBook {}");
        bookRepository.save(book);
    }

    @Override
    public Book getBook(String isbn) {
        log.info("Inside getBook {}");
        return bookRepository.findBookByIsbn(isbn);
    }

    @Override
    public boolean deleteBook(String isbn) {
        log.info("Inside deleteBook {}");
        bookRepository.delete(isbn);
        return true;
    }

    @Override
    public Collection<Book> getAllBooks() {
        log.info("Inside getAllBooks {}");
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }
}
