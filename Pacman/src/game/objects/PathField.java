package game.objects;

import game.common.CommonField;
import game.common.CommonMazeObject;

public class PathField extends Field {

    public PathField(Maze maze, int x, int y) {
        super(maze, x, y);
    }

    @Override
    public boolean isEmpty() {
        return objects.isEmpty();
    }

    @Override
    public CommonField nextField(Direction dir) {
        switch (dir) {
            case L:
                return maze.getField(x - 1, y);
            case U:
                return maze.getField(x, y - 1);
            case R:
                return maze.getField(x + 1, y);
            case D:
                return maze.getField(x, y + 1);
        }
        return null;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public boolean contains(CommonMazeObject obj) {
        return objects.contains(obj);
    }

    @Override
    public void put(CommonMazeObject obj) {
        objects.add(obj);
    }
    
}
