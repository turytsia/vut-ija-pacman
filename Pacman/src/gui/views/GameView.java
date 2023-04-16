package gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import game.common.CommonField;
import game.objects.Maze;
import game.view.MazeView;
import gui.Game;

public class GameView extends View {

    private Maze maze;

    public GameView(Maze maze, Game game) {
        super(new BorderLayout(), game);
        
        this.maze = maze;

        setBackground(Color.BLACK);
        System.out.println(game);
        MazeView mazePanel = new MazeView(maze, game);
        mazePanel.setPreferredSize(new Dimension(600, 600));

        JPanel center = new JPanel();
        JPanel top = new JPanel(new BorderLayout());
        JPanel bottom = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();

        JPanel infoContainerTop = new JPanel(new GridLayout(1,4));
        JPanel healthContainer = new JPanel(new GridLayout(1, 3));
        // healthContainer.setPreferredSize(new Dimension(90, 40));

        for (int i = 0; i < maze.getPacman().getLives(); i++) {
            Image heartImage = new ImageIcon("data/assets/sprites/game/heart.png").getImage();
            JLabel heart = new JLabel(new ImageIcon(heartImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
            healthContainer.add(heart);
        }
        
        // top.add(new JLabel());
        // top.add(new JLabel());
        // top.add(new JLabel());

        JPanel topLeft = new JPanel();
        JPanel topRight = new JPanel();

        top.setOpaque(false);
        topLeft.setOpaque(false);
        topRight.setOpaque(false);
        healthContainer.setOpaque(false);
        infoContainerTop.setOpaque(false);

        topLeft.setPreferredSize(new Dimension((config.getWidth() - 600) / 2, 40));
        topRight.setPreferredSize(new Dimension((config.getWidth() - 600) / 2, 40));


        infoContainerTop.add(new gui.components.Label("Score: 0.00"));
        infoContainerTop.add(new JLabel());
        infoContainerTop.add(new JLabel());
        infoContainerTop.add(healthContainer);

        top.add(topLeft, BorderLayout.WEST);
        top.add(topRight, BorderLayout.EAST);
        top.add(infoContainerTop, BorderLayout.CENTER);

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
    }
        
        

    @Override
    protected void KeyArrowUp() {
        System.out.println("Move pacman up");
        maze.getPacman().move(CommonField.Direction.U);
    }

    @Override
    protected void KeyArrowRight() {
        System.out.println("Move pacman right");
        maze.getPacman().move(CommonField.Direction.R);
    }

    @Override
    protected void KeyArrowDown() {
        System.out.println("Move pacman down");
        maze.getPacman().move(CommonField.Direction.D);
    }

    @Override
    protected void KeyEscape() {
        game.popView();
    }

    @Override
    protected void KeyEnter() {

    }
    
}
