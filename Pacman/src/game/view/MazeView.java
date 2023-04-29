package game.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import game.common.CommonField;
import game.objects.Maze;
import gui.Game;

/**
 * A class representing the graphic form of a maze
 * 
 * @autor Turtysia Oleksandr (xturyt00)
 * @version %I%, %G%
 */
public class MazeView extends JPanel {
    public MazeView(Maze maze, Game game) {
        setLayout(new GridLayout(maze.numRows(), maze.numCols()));
        setOpaque(false);
        for (int i = 0; i < maze.numRows(); ++i) {
            for (int j = 0; j < maze.numCols(); ++j) {
                CommonField field = maze.getField(j, i);
                
                if (field.canMove()) {
                    add(new FieldView(field, game));
                } else {
                    add(new WallView());
                }
            }
        }
    }
}
