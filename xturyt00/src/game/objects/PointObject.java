package game.objects;

import game.common.CommonField;
import game.common.CommonField.Direction;

/**
 * Class representing point object.
 * 
 * @author Oleksandr Turytsia (xturyt00)
 * @author Kambulat Alakaev (xalaka00)
 * @version 1.0
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
