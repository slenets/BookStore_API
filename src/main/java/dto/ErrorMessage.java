package dto;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class ErrorMessage {
    String userId;
    int code;
    String message;
}
