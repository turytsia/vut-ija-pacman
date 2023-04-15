package game.objects;

import game.common.CommonField;

public class GhostObject extends MazeObject {

    public GhostObject(CommonField field) {
        super(field);
    }

    @Override
    public int getLives() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getLives'");
    }

    @Override
    public boolean isPacman() {
        return false;
    }
}
