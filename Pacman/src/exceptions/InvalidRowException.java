package exceptions;

public class InvalidRowException extends Exception {
    public InvalidRowException() {
        super();
    }

    public InvalidRowException(String message) {
        super(message);
    }
}
