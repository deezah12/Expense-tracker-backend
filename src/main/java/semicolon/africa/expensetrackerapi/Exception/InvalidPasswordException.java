package semicolon.africa.expensetrackerapi.Exception;

public class InvalidPasswordException extends  RuntimeException{
    public InvalidPasswordException(String message) {
        super(message);
    }
}
