package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class UserAuth {
    String userName;
    String password;
}
