package dto;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class Book {
    String isbn;
    String title;
    String subTitle;
    String author;
    String publishDate;
    String publisher;
    int pages;
    String description;
    String website;
}
