package game.objects;

import game.common.CommonField;

public class FinishObject extends MazeObject {

    public FinishObject(CommonField field) {
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
