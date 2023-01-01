package semicolon.africa.expensetrackerapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.expensetrackerapi.dto.request.LoginRequest;
import semicolon.africa.expensetrackerapi.dto.request.SignInRequest;
import semicolon.africa.expensetrackerapi.dto.response.LoginResponse;
import semicolon.africa.expensetrackerapi.service.ExpenseUserService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpenseUserServiceImplTest {

    @Autowired
    ExpenseUserService expenseUserService;

    @Test
    void signUp() {
        SignInRequest signInRequest = new SignInRequest();

        signInRequest.setFirstName("Hadiza");
        signInRequest.setLastName("umar");
        signInRequest.setEmail("Hadiza2022@");
        signInRequest.setPassword("12345");
        signInRequest.setCreatedTime(signInRequest.getCreatedTime());
        var signIn = expenseUserService.signUp(signInRequest);
        assertEquals("successful", signIn.getMessage());
    }


    @Test
    void loginIn() {
        LoginRequest loginRequest  = new LoginRequest();
        loginRequest.setEmail("Hadiza2022@");
        loginRequest.setPassword("12*hadiZa");
        var login =expenseUserService.loginIn(loginRequest);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("successful");


    }

    @Test
    void deleteUser() {
    }
}