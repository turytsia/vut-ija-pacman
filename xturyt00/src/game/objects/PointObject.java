package game.objects;

import game.common.CommonField;
import game.common.CommonField.Direction;

/**
 * Class representing point object.
 * 
 * @autor Oleksandr Turytsia (xturyt00)
 * @autor Kambulat Alakaev (xalaka00)
 * @version %I%, %G%
 */
public class PointObject extends MazeObject {

    public PointObject(CommonField field) {
        super(field);
    }

    @Override
    public boolean isPacman() {
        return false;
    }

    @Override
    public int getLives() {
        throw new UnsupportedOperationException("Unimplemented method 'getLives'");
    }

    @Override
    public boolean move(Direction dir) {
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
