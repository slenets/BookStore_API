package dto;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class User {
    String userId;
    String userName;
    List<Book> books;
}
