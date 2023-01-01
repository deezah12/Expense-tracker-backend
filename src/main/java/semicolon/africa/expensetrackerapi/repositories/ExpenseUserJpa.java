package semicolon.africa.expensetrackerapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.expensetrackerapi.models.ExpenseUser;


public interface ExpenseUserJpa extends MongoRepository<ExpenseUser, String> {
    ExpenseUser findByEmail(String email);
}
