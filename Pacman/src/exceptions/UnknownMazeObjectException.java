package exceptions;

public class UnknownMazeObjectException extends Exception {
    public UnknownMazeObjectException() {
        super();
    }

    public UnknownMazeObjectException(String message) {
        super(message);
    }
}
