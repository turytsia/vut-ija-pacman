package game.objects;

import game.common.CommonField;
import game.common.CommonField.Direction;
import game.common.CommonMazeObject;

/**
 * Abstract class representing all maze objects (their general behaviour)
 * 
 * @author Oleksandr Turytsia (xturyt00)
 * @author Kambulat Alakaev (xalaka00)
 * @version %I%, %G%
 */
public abstract class MazeObject implements CommonMazeObject {

    public CommonField field;

    private int id;
    private int x;
    private int y;

    public MazeObject(CommonField field) {
        this.field = field;
        this.x = field.getX();
        this.y = field.getY();
        this.id = field.getMaze().nextId();
    }

    @Override
    public boolean canMove(Direction dir) {
        throw new UnsupportedOperationException("Unimplemented method 'canMove'");
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
    public CommonField getField() {
        return field;
    }

    @Override
    public void setField(CommonField field) {
        this.field = field;
    }

    @Override
    public int getId() {
        return this.id;
    }

}
