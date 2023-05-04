package exceptions;

/**
 * Class that implements custome exception for maze file reading.
 * Game throws this type of error when maze file has invalid maze object
 * 
 * @author Oleksandr Turytsia (xalaka00)
 * @version 1.0
 */
public class UnknownMazeObjectException extends Exception {
    public UnknownMazeObjectException() {
        super();
    }

    public UnknownMazeObjectException(String message) {
        super(message);
    }
}
