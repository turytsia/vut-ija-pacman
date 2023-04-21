package game.objects;

import game.common.AbstractObservableField;
import game.common.CommonMazeObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Field extends AbstractObservableField {

    protected Maze maze;
    protected int x;
    protected int y;

    protected List<CommonMazeObject> objects = new ArrayList<>();

    public Field(Maze maze, int x, int y) {
        this.maze = maze;
        this.x = x;
        this.y = y;
    }

    @Override
    public void unbindObj(CommonMazeObject obj) {
        if (!this.objects.isEmpty()) {
            obj.unbindField();
            this.objects.remove(obj);
            this.notifyObservers();
        }
    }

    public int getX() {
        return this.x;
    }

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
