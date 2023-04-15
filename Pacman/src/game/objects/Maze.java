package game.objects;

import java.util.ArrayList;
import java.util.List;

import exceptions.MazeRowOutOfBoundsException;
import exceptions.UnknownMazeObjectException;
import game.common.CommonField;
import game.common.CommonMaze;
import game.common.CommonMazeObject;

public class Maze implements CommonMaze {
    
    private int cols;
    private int rows;
    List<List<CommonField>> fields = new ArrayList<>();
    List<CommonMazeObject> ghosts = new ArrayList<>();

    public Maze(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    private PathField createGhost(int x, int y) {
        PathField field = new PathField(this, x, y);
        field.put(new GhostObject(field));

        return field;
    }

    private PathField createKey(int x, int y) {
        PathField field = new PathField(this, x, y);
        field.put(new KeyObject(field));

        return field;
    }

    private PathField createFinish(int x, int y) {
        PathField field = new PathField(this, x, y);
        field.put(new FinishObject(field));

        return field;
    }

    private PathField createPacman(int x, int y) {
        PathField field = new PathField(this, x, y);
        field.put(new PacmanObject(field));

        return field;
    }

    @Override
    public void parseLine(String line) {
        ArrayList<CommonField> row = new ArrayList<>();
        try {
            if (fields.size() >= rows) {
                throw new MazeRowOutOfBoundsException("Too much rows in a file");
            }

            for (char c : line.toCharArray()) {
                int x = fields.size();
                int y = row.size();
                switch (c) {
                    case 'X':
                        row.add(new WallField(this, x, y));
                        break;
                    case 'G':
                        row.add(createGhost(x, y));
                        break;
                    case 'K':
                        row.add(createKey(x, y));
                        break;
                    case 'T':
                        row.add(createFinish(x, y));
                        break;
                    case 'S':
                        row.add(createKey(x, y));
                        break;
                    case '.':
                        row.add(createPacman(x, y));
                        break;
                    default:
                        throw new UnknownMazeObjectException("Object " + c + " is not valid");
                }
            }

            fields.add(row);
        } catch (MazeRowOutOfBoundsException | UnknownMazeObjectException e) {
            e.printStackTrace();
        }

    }

    @Override
    public CommonField getField(int x, int y) {
        try{
            return fields.get(x).get(y);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int numRows() {
        return this.rows;
    }

    @Override
    public int numCols() {
        return this.cols;
    }

    @Override
    public List<CommonMazeObject> ghosts() {
        return new ArrayList<CommonMazeObject>(this.ghosts);
    }
    
}
