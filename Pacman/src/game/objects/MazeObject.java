package game.objects;

import game.common.CommonField;
import game.common.CommonField.Direction;
import game.common.CommonMazeObject;

public abstract class MazeObject implements CommonMazeObject {

    public CommonField field;

    public MazeObject(CommonField field) {
        this.field = field;
    }

    @Override
    public boolean canMove(Direction dir) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canMove'");
    }

    public int getX(){ return ((Field)field).getX();}
    public int getY(){ return ((Field)field).getY();}

    @Override
    public void unbindField(){
        this.field = null;
    }
    @Override
    public boolean move(Direction dir) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public CommonField getField() {
        return field;
    }

    @Override
    public void setField(CommonField field) {
        this.field = field;
    }
    
    
}
