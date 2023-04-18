package game.objects;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exceptions.MazeRowOutOfBoundsException;
import exceptions.UnknownMazeObjectException;
import game.MazeConfigure;
import game.common.CommonField;
import game.common.CommonMaze;
import game.common.CommonMazeObject;
import gui.components.Label;

public class Maze implements CommonMaze {

    private int cols;
    private int rows;
    private List<List<CommonField>> fields = new ArrayList<>();
    private final List<GhostObject> ghosts = new ArrayList<>();
    private PacmanObject pacman;

    private Label scoreText;
    private JPanel healthContainer;
    private File mazeFile;

    public Maze(int cols, int rows, File mazeFile) {
        this.cols = cols;
        this.rows = rows;
        this.mazeFile = mazeFile;

        scoreText = new Label("Score: 0");
        healthContainer = new JPanel(new GridLayout(1, 3));
        healthContainer.setOpaque(false);
    }

    public void updateScore() {
        scoreText.setText("Score: " + getPacman().getScore());
    }

    public void updateHealth() {

        for (int i = healthContainer.getComponentCount(); i > getPacman().getLives() && i > 0; i--) {
            healthContainer.remove(i - 1);
        }
    }

    private void createHealthContainer() {
        for (int i = 0; i < getPacman().getLives(); i++) {
            Image heartImage = new ImageIcon("data/assets/sprites/game/heart.png").getImage();
            JLabel heart = new JLabel(new ImageIcon(heartImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
            healthContainer.add(heart);
        }
    }

    public Label getScoreText() {
        return this.scoreText;
    }

    public JPanel getHealthContainer() {
        return this.healthContainer;
    }

    public String getMazeName() {
        Pattern pattern = Pattern.compile("(.*)\\.");
        Matcher matcher = pattern.matcher(mazeFile.getName());

        if (matcher.find()) {
            return matcher.group(1);
        }
        return "Maze";
    }

    public File getMazeFile() {
        return this.mazeFile;
    }

    private PathField createGhost(int x, int y) {
        PathField field = new PathField(this, x, y);
        GhostObject ghost = new GhostObject(field);
        ghosts.add(ghost);
        field.put(ghost);

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
        pacman = new PacmanObject(field);
        field.put(pacman);

        createHealthContainer();

        return field;
    }

    private PathField createPoint(int x, int y) {
        PathField field = new PathField(this, x, y);
        field.put(new PointObject(field));

        return field;
    }

    public PacmanObject getPacman() {
        return pacman;
    }

    @Override
    public void parseLine(String line) {
        ArrayList<CommonField> row = new ArrayList<>();
        try {
            if (fields.size() >= rows) {
                throw new MazeRowOutOfBoundsException("Too much rows in a file");
            }

            for (char c : line.toCharArray()) {
                int y = fields.size();
                int x = row.size();
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
                        row.add(createPacman(x, y));
                        break;
                    case '.':
                        row.add(createPoint(x, y));
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
        try {
            return fields.get(y).get(x);
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
    public List<GhostObject> ghosts() {
        return this.ghosts;
    }

}
