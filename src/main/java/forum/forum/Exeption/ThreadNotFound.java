package forum.forum.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ThreadNotFound extends RuntimeException{
    public ThreadNotFound() {
    }

    public ThreadNotFound(String message) {
        super(message);
    }

    public ThreadNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ThreadNotFound(Throwable cause) {
        super(cause);
    }
}
