package exceptions;

/**
 * Class that implements custome exception for maze file reading.
 * Game throws this type of error when maze file has invalid maze object
 * 
 * @autor Oleksandr Turytsia (xalaka00)
 * @version %I%, %G%
 */
public class UnknownMazeObjectException extends Exception {
    public UnknownMazeObjectException() {
        super();
    }

    public UnknownMazeObjectException(String message) {
        super(message);
    }
}
