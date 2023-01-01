package semicolon.africa.expensetrackerapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import semicolon.africa.expensetrackerapi.Exception.InvalidPasswordException;
import semicolon.africa.expensetrackerapi.Exception.UsernameNotFoundException;
import semicolon.africa.expensetrackerapi.dto.request.LoginRequest;
import semicolon.africa.expensetrackerapi.dto.request.SignInRequest;
import semicolon.africa.expensetrackerapi.dto.response.LoginResponse;
import semicolon.africa.expensetrackerapi.dto.response.SignInResponse;
import semicolon.africa.expensetrackerapi.models.ExpenseUser;
import semicolon.africa.expensetrackerapi.repositories.ExpenseUserJpa;
import semicolon.africa.expensetrackerapi.service.ExpenseUserService;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class ExpenseUserServiceImpl implements ExpenseUserService {

    @Autowired
    ExpenseUserJpa expenseUserJpa;

    @Override
    public SignInResponse signUp(SignInRequest signInRequest){
        ExpenseUser user = new ExpenseUser();

        user.setEmail(signInRequest.getEmail());
        user.setFirstName(signInRequest.getFirstName());
        user.setLastName(signInRequest.getLastName());
        user.setPassword(hashPassword(signInRequest.getPassword()));
        user.setCreatedDate(LocalDateTime.now());
        expenseUserJpa.save(user);

        SignInResponse signInResponse = new SignInResponse("successful");
        return signInResponse;
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public LoginResponse loginIn(LoginRequest loginRequest) {
        var login = expenseUserJpa.findByEmail(loginRequest.getEmail());
        if (Objects.isNull(login)) throw  new UsernameNotFoundException("email does not exist");
        if (!BCrypt.checkpw(loginRequest.getPassword(), login.getPassword())) {
            throw  new InvalidPasswordException("password does not match");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Successful");
        return loginResponse;
    }

    @Override
    public void deleteUser(String id) {
        if (expenseUserJpa.existsById(id)) {
            expenseUserJpa.deleteById(id);
        }

    }
}
