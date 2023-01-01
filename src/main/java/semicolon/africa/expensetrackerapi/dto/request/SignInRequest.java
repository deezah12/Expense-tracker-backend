package semicolon.africa.expensetrackerapi.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SignInRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
