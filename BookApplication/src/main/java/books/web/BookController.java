package books.web;

import books.domain.Book;
import books.service.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/test")
    public String apiTest() {
        return "Working Good!";
    }

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        log.info("Add book");
        bookService.addBook(book);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable(value = "isbn") String isbn) {
        log.info("Get a book by isbn: " + isbn);
        Book book = bookService.getBook(isbn);
        if (book == null) {
            log.info("Book record not found with the given isbn ", isbn);
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book record is not found with the given isbn:  "
                    + isbn), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable("isbn") String isbn, @RequestBody Book book) {
        log.info("Updating book record by isbn: " + isbn);
        Book bookToUpdate = bookService.getBook(isbn);
        if (bookToUpdate == null) {
            log.info("Book record could not updated!");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        bookService.updateBook(book);
        log.info("Book record has updated Successfully!");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public Collection<?> getAllBooks() {
        log.info("Fetch all books {}");
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{isbn}")
    public String removeBook(@PathVariable("isbn") String isbn, HttpServletResponse response) {
        log.info("Remove book by isbn: " + isbn);
        Book bookToRemoved = bookService.getBook(isbn);
        if (bookToRemoved == null) {
            log.info("Record not found!");
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return "Book record could not deleted!";
        }

        boolean isSuccess = bookService.deleteBook(isbn);
        if (!isSuccess) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return "Book record could not deleted!";
        }
        response.setStatus(HttpStatus.OK.value());
        return "Book record has Successfully deleted!";
    }

    @DeleteMapping("/{isbn1}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "isbn1") String isbn) {
        log.info("delete Book by isbn " + isbn);
        Book book = bookService.getBook(isbn);
        if (book == null) {
            log.info("Book record could not found");
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book record is not found with given isbn:  "
                    + isbn), HttpStatus.NOT_FOUND);
        }
        boolean isSuccess = bookService.deleteBook(isbn);
        if (!isSuccess) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book record could not deleted!"),
                    (HttpStatus.INTERNAL_SERVER_ERROR));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
