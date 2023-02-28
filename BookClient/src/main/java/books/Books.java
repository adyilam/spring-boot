package books;

import lombok.*;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Books {
    private Collection<Book> books =new ArrayList<>();

}
