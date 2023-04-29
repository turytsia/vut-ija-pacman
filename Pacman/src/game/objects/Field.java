package game.objects;

import game.common.AbstractObservableField;
import game.common.CommonMazeObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class representing every field in the maze
 * 
 * @autor Oleksandr Turytsia (xturyt00)
 * @autor Kambulat Alakaev (xalaka00)
 * @version %I%, %G%
 */
public abstract class Field extends AbstractObservableField {

    protected Maze maze;
    protected int x;
    protected int y;

    protected final List<CommonMazeObject> objects = new ArrayList<>();

    public Field(Maze maze, int x, int y) {
        this.maze = maze;
        this.x = x;
        this.y = y;
    }

    @Override
    public void remove(CommonMazeObject obj) {
        if (this.objects.isEmpty())
            return;

        this.objects.remove(obj);
        this.notifyObservers();

    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public List<CommonMazeObject> get() {
        return objects;
    }

    @Override
    public Maze getMaze() {
        return this.maze;
    }

}
