package exceptions;

/**
 * Class that implements custome exception for maze file reading.
 * Game throws this type of error when maze file has invalid number of rows
 * 
 * @author Oleksandr Turytsia (xalaka00)
 * @version %I%, %G%
 */
public class MazeRowOutOfBoundsException extends Exception {
    public MazeRowOutOfBoundsException() {
        super();
    }

    public MazeRowOutOfBoundsException(String message) {
        super(message);
    }
}
