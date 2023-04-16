package game.objects;

import game.common.AbstractObservableField;
import game.common.CommonMazeObject;

public abstract class Field extends AbstractObservableField {

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
    public void unbindObj(){
        this.object = null;
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}
    @Override
    public CommonMazeObject get() {
        return object;
    }
    
}
