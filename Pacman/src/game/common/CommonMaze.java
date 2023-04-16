package game.common;

import game.objects.GhostObject;

import java.util.List;

public interface CommonMaze {
    public CommonField getField(int x, int y);

    public int numRows();

    public int numCols();

    public List<GhostObject> ghosts();

    public void parseLine(String line);
}
