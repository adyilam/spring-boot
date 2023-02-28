package books;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({ "isbn", "author", "title", "price" })
public class Book {

    private String isbn;
    private String author;
    private String title;
    private double price;
}
