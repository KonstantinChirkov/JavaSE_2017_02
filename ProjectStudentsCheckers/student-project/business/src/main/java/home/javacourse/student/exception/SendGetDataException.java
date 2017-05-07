package home.javacourse.student.exception;

/**
 * Created by Mozart on 16.03.2017.
 */
public class SendGetDataException extends Exception {
    public SendGetDataException(String message) {
        super(message);
    }
    public SendGetDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
