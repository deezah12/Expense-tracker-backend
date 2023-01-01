package semicolon.africa.expensetrackerapi.service;

import semicolon.africa.expensetrackerapi.dto.request.LoginRequest;
import semicolon.africa.expensetrackerapi.dto.request.SignInRequest;
import semicolon.africa.expensetrackerapi.dto.response.LoginResponse;
import semicolon.africa.expensetrackerapi.dto.response.SignInResponse;

public interface ExpenseUserService {
    LoginResponse loginIn(LoginRequest loginRequest);
    SignInResponse signUp(SignInRequest signInRequest);
    void deleteUser(String id);
}
