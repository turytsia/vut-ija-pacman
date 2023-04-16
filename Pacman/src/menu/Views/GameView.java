package menu.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.common.CommonField;
import game.objects.Maze;
import game.view.MazeView;

public class GameView extends View {

    private Maze maze;

    private MazeView mazePanel;

    public GameView(Maze maze) {
        super(new BorderLayout());
        
        this.maze = maze;

        setBackground(Color.BLACK);
        mazePanel = new MazeView(maze);
        mazePanel.setPreferredSize(new Dimension(600, 600));

        JPanel center = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();

        center.setOpaque(false);
        top.setOpaque(false);
        bottom.setOpaque(false);
        left.setOpaque(false);
        right.setOpaque(false);

        center.add(mazePanel);

        add(center, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);
    }

    @Override
    protected void KeyArrowLeft() {
        System.out.println("Move pacman left");
        maze.getPacman().move(CommonField.Direction.L);
        menu.update();
    }
        
        

    @Override
    protected void KeyArrowUp() {
        System.out.println("Move pacman up");
        maze.getPacman().move(CommonField.Direction.U);
        menu.update();
    }

    @Override
    protected void KeyArrowRight() {
        System.out.println("Move pacman right");
        maze.getPacman().move(CommonField.Direction.R);
        menu.update();
    }

    @Override
    protected void KeyArrowDown() {
        System.out.println("Move pacman down");
        maze.getPacman().move(CommonField.Direction.D);
        menu.update();
    }

    @Override
    protected void KeyEscape() {
        menu.popView();
    }

    @Override
    protected void KeyEnter() {

    }
    
}
