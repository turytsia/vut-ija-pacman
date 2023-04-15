package exceptions;

public class MazeRowOutOfBoundsException extends Exception {
    public MazeRowOutOfBoundsException() {
        super();
    }

    public MazeRowOutOfBoundsException(String message) {
        super(message);
    }
}
