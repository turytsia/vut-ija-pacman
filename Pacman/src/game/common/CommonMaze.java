package game.common;

import java.util.List;

public interface CommonMaze {
    public CommonField getField(int x, int y);

    public int numRows();

    public int numCols();

    public List<CommonMazeObject> ghosts();

    public void parseLine(String line);
}
