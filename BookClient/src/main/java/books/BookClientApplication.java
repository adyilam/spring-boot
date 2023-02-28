package books;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.DataInput;
import java.util.List;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
@SpringBootApplication
public class BookClientApplication implements CommandLineRunner {

    @Autowired
    private RestOperations restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BookClientApplication.class, args);
    }

    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        String serverUrl = "http://localhost:8080/api/books";

        // add Software Architecture
        restTemplate.postForLocation(serverUrl + "/book", new Book("0137314911", "David Farley", "Modern Software Engineering",
                35.99));

        // add Head First Software Developer
        restTemplate.postForLocation(serverUrl + "/book", new Book("0596527358", "Dan Pilone", "Head First Software Development",
                25.88));

        // get Head First Software Developer by ISBN
        Book book = restTemplate.getForObject(serverUrl + "/{isbn}", Book.class, "0596527358");
        System.out.println("----------- get Head First Software Developer Book -----------------------");
        System.out.println("\n ISBN: " + book.getIsbn() + "\n Title: " + book.getTitle()
                + "\n Author: " + book.getAuthor());

        // get all Books
        Books books = restTemplate.getForObject(serverUrl + "/", Books.class);
        System.out.println("----------- get all Books-----------------------");
        System.out.println(books);

        // delete Head First Software Developer book
        // restTemplate.delete(serverUrl + "/{isbn}", "0596527358");

        // update price of Head First Software Developer book
         book.setPrice(26.88);
         restTemplate.put(serverUrl+"/{isbn}", book, book.getPrice());

        /*// get all Books
        books= restTemplate.getForObject(serverUrl + "/", Books.class);
        System.out.println("----------- get all Books-----------------------");
        System.out.println(books);*/
    }


}
