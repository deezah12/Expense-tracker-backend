package semicolon.africa.expensetrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import semicolon.africa.expensetrackerapi.dto.request.SignInRequest;
import semicolon.africa.expensetrackerapi.dto.response.SignInResponse;
import semicolon.africa.expensetrackerapi.service.ExpenseUserService;

@RestController
@RequestMapping("/api/v1/users")
public class ExpenseUserController {
    @Autowired
    ExpenseUserService expenseUserService;

    @PostMapping("/signup")
    public ResponseEntity<SignInResponse> signUP(@RequestBody SignInRequest signInRequest) {
            var sign = expenseUserService.signUp(signInRequest);
            return new ResponseEntity<>(new SignInResponse(sign.getMessage()), HttpStatus.CREATED);
        }
}

