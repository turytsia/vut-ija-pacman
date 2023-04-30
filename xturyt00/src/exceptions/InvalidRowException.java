package exceptions;

/**
 * Class that implements custome exception for maze file reading.
 * Game throws this type of error when maze file has invalid number of rows (it
 * differs from specification)
 * 
 * @author Oleksandr Turytsia (xalaka00)
 * @version %I%, %G%
 */
public class InvalidRowException extends Exception {
    public InvalidRowException() {
        super();
    }

    public InvalidRowException(String message) {
        super(message);
    }
}
