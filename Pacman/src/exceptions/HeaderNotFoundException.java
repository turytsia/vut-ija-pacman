package exceptions;

/**
 * Class that implements custome exception for maze file reading.
 * Game throws this type of error when maze file has invalid header
 * 
 * @autor  Oleksandr Turytsia (xalaka00)
 * @version %I%, %G%
 */
public class HeaderNotFoundException extends Exception {
    public HeaderNotFoundException() {
        super();
    }

    public HeaderNotFoundException(String message) {
        super(message);
    }
}
