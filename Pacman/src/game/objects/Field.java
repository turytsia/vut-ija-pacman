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


    public boolean leaveObjOnField(int listSize){
        CommonMazeObject obj = this.objects.get(0);
        return listSize == 1 &&
                (obj instanceof GhostObject || obj instanceof FinishObject);
    }

    @Override
    public void unbindObj() {
        if (!this.objects.isEmpty()) {

            int listSize = this.objects.size();
            if (!leaveObjOnField(listSize)){
//                System.out.println("Unbound: "+ this.objects.get(listSize-1).getClass().getName());
                this.objects.get(listSize-1).unbindField();
                this.objects.remove(listSize-1);
            }

        }
        this.notifyObservers();
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}
    @Override
    public List<CommonMazeObject> get() {
        return objects;
    }
    
}
