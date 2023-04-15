package game.objects;

import game.common.CommonField;

public class PacmanObject extends MazeObject {

    private int lives = 3;

    public PacmanObject(CommonField field) {
        super(field);
    }

    @Override
    public boolean isPacman() {
        return true;
    }

    @Override
    public int getLives() {
        return lives;
    }
    
}
