package books;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {

    private String isbn;
    private String author;
    private String title;
    private double price;
}
