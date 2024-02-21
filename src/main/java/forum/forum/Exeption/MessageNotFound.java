package forum.forum.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MessageNotFound extends RuntimeException{
    public MessageNotFound() {
    }

    public MessageNotFound(String message) {
        super(message);
    }

    public MessageNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageNotFound(Throwable cause) {
        super(cause);
    }
}
