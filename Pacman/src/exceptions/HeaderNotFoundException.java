package exceptions;

public class HeaderNotFoundException extends Exception {
    public HeaderNotFoundException() {
        super();
    }

    public HeaderNotFoundException(String message) {
        super(message);
    }
}
