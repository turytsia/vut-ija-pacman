package game.objects;

import game.common.CommonField;

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
    
}
