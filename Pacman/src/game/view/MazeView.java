package game.view;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import game.common.CommonField;
import game.objects.Maze;

public class MazeView extends JPanel {
    public MazeView(Maze maze) {
        setLayout(new GridLayout(maze.numRows(), maze.numCols()));
        setOpaque(false);
        for (int i = 0; i < maze.numRows(); ++i) {
            for (int j = 0; j < maze.numCols(); ++j) {
                CommonField field = maze.getField(j, i);
                
                if (field.canMove()) {
                    add(new FieldView(field));
                } else {
                    add(new WallView());
                }
            }
        }
    }
}
