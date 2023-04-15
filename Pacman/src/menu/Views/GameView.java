package menu.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.objects.Maze;
import menu.MazeOverview;

public class GameView extends View {

    public GameView(Maze maze) {
        super(new BorderLayout());
        setBackground(Color.BLACK);
        MazeOverview mazePanel = new MazeOverview(maze);
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
    }

    @Override
    protected void KeyArrowUp() {
        
    }

    @Override
    protected void KeyArrowRight() {

    }

    @Override
    protected void KeyArrowDown() {

    }

    @Override
    protected void KeyEscape() {
        menu.popView();
    }

    @Override
    protected void KeyEnter() {

    }
    
}
