package semicolon.africa.expensetrackerapi.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private  String password;
    private String email;
}
