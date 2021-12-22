package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class GenerateTokenResponse {
    String token;
    String expires;
    String status;
    String result;

}
