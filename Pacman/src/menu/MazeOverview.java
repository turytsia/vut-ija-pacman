package menu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import game.common.CommonField;
import game.objects.Maze;
import game.objects.WallField;
import menu.game.WallView;

public class MazeOverview extends JPanel {
    public MazeOverview(Maze maze) {
        setLayout(new GridLayout(maze.numRows(), maze.numCols()));
        setOpaque(false);
        for (int x = 0; x < maze.numRows(); x++) {
            for (int y = 0; y < maze.numCols(); y++) {
                CommonField field = maze.getField(x, y);
                JPanel t = new JPanel();
                if (field instanceof WallField) {
                    add(new WallView());
                } else {
                    t.setBackground(Color.GREEN);
                    add(t);
                }
            }
        }
    }
}
