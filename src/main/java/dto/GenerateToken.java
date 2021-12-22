package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class GenerateToken {
    String token;
    String expires;
    String status;
    String result;
}
