package game.common;

import java.util.List;

import game.objects.Maze;

public interface CommonField extends Observable {

    public static enum Direction {
        L,
        U,
        R,
        D
    }

    public CommonField nextField(CommonField.Direction dir);

    public boolean isEmpty();

    public void unbindObj();

    public List<CommonMazeObject> get();

    public  boolean canMove();

    public int getX();
    public int getY();

    public boolean contains(CommonMazeObject obj);

    public void put(CommonMazeObject obj);

    public Maze getMaze();
}
