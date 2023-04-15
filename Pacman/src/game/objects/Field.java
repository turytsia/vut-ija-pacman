package game.objects;

import game.common.CommonField;
import game.common.CommonMazeObject;

public abstract class Field implements CommonField {

    protected Maze maze;
    protected int x;
    protected int y;

    protected CommonMazeObject object = null;

    public Field(Maze maze, int x, int y) {
        this.maze = maze;
        this.x = x;
        this.y = y;
    }


    @Override
    public CommonMazeObject get() {
        return object;
    }
    
}
