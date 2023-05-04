package exceptions;

/**
 * Class that implements custome exception for maze file reading.
 * Game throws this type of error when maze file has invalid header
 * 
 * @author Oleksandr Turytsia (xalaka00)
 * @version 1.0
 */
public class HeaderNotFoundException extends Exception {
    public HeaderNotFoundException() {
        super();
    }

    public HeaderNotFoundException(String message) {
        super(message);
    }
}
