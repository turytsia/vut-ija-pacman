package game.objects;

import game.common.CommonField;
import game.common.CommonMazeObject;

/**
 * Class representing wall in maze.
 * 
 * @autor Turtysia Oleksandr (xturyt00)
 * @autor Kambulat Alakaev (xalaka00)
 * @version %I%, %G%
 */
public class WallField extends Field {

    public WallField(Maze maze, int x, int y) {
        super(maze, x, y);
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean contains(CommonMazeObject obj) {
        return false;
    }

    @Override
    public CommonField nextField(Direction dir) {
        throw new UnsupportedOperationException("Unimplemented method 'nextField'");
    }

    @Override
    public void put(CommonMazeObject obj) {
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }
    
}
