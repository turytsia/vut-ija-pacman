package game.common;

public interface CommonField extends Observable {

    public static enum Direction {
        L,
        T,
        R,
        D
    }

    public CommonField nextField(CommonField.Direction dir);

    public boolean isEmpty();

    public CommonMazeObject get();

    public  boolean canMove();

    public boolean contains(CommonMazeObject obj);

    public void put(CommonMazeObject obj);
}
