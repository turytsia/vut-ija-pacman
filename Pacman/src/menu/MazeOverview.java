package menu;

import java.awt.GridLayout;

import javax.swing.JPanel;

import game.common.CommonField;
import game.objects.Maze;
import game.view.FieldView;
import game.view.PointView;
import game.view.WallView;

public class MazeOverview extends JPanel {
    public MazeOverview(Maze maze) {
        setLayout(new GridLayout(maze.numRows(), maze.numCols()));
        setOpaque(false);
        for (int i = 0; i < maze.numRows(); ++i) {
            for (int j = 0; j < maze.numCols(); ++j) {
                CommonField field = maze.getField(i, j);
                if (field.canMove()) {
                    add(new FieldView(maze.getField(i, j)));
                } else {
                    add(new WallView());
                }
            }
        }
    }
}
