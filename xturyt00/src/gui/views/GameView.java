package gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.common.CommonField;
import game.objects.Maze;
import game.view.MazeView;
import gui.Game;
import gui.components.Label;

/**
 * This class represents playable view.
 * 
 * Here user can play the game itself. In this view
 * you can see pacman, maze, ghosts, keys, finish and score.
 * 
 * @autor Oleksandr Turytsia (xturyt00)
 * @version %I%, %G%
 */
public class GameView extends View {

    /* PANELS */
    private final MazeView mazePanel = new MazeView(maze, game);
    private final JPanel center = new JPanel();
    private final JPanel top = new JPanel(new BorderLayout());
    private final JPanel bottom = new JPanel();
    private final JPanel left = new JPanel();
    private final JPanel right = new JPanel();
    private final JPanel infoContainerTop = new JPanel(new GridLayout(1, 5));
    private final JPanel topLeft = new JPanel();
    private final JPanel topRight = new JPanel();

    public GameView(Maze maze, Game game) {
        super(game, maze);

        setBackground(Color.BLACK);

        this.maze.setPause(false);

        container.setLayout(new BorderLayout());

        mazePanel.setPreferredSize(new Dimension(550, 550));

        top.setOpaque(false);
        topLeft.setOpaque(false);
        topRight.setOpaque(false);
        infoContainerTop.setOpaque(false);

        topLeft.setPreferredSize(new Dimension((config.getWidth() - 600) / 2, 40));
        topRight.setPreferredSize(new Dimension((config.getWidth() - 600) / 2, 40));


        Label scoreText = maze.getMazeComponent().getScoreText();
        scoreText.setHorizontalAlignment(SwingConstants.CENTER);

        infoContainerTop.add(scoreText);
        infoContainerTop.add(new JLabel());
        infoContainerTop.add(maze.getMazeComponent().getKeyContainer());
        infoContainerTop.add(new JLabel());
        infoContainerTop.add(maze.getMazeComponent().getHealthContainer());

        top.add(topLeft, BorderLayout.WEST);
        top.add(topRight, BorderLayout.EAST);
        top.add(infoContainerTop, BorderLayout.CENTER);

        center.setOpaque(false);
        top.setOpaque(false);
        bottom.setOpaque(false);
        left.setOpaque(false);
        right.setOpaque(false);

        center.add(mazePanel);

        container.add(center, BorderLayout.CENTER);
        container.add(top, BorderLayout.NORTH);
        container.add(bottom, BorderLayout.SOUTH);
        container.add(left, BorderLayout.WEST);
        container.add(right, BorderLayout.EAST);

        container.setBackground(Color.black);

        add(container, BorderLayout.CENTER);
    }

    @Override
    protected void KeyArrowLeft() {
        maze.getPacman().move(CommonField.Direction.L);
    }

    @Override
    protected void KeyArrowUp() {
        maze.getPacman().move(CommonField.Direction.U);
    }

    @Override
    protected void KeyArrowRight() {
        maze.getPacman().move(CommonField.Direction.R);
    }

    @Override
    protected void KeyArrowDown() {
        maze.getPacman().move(CommonField.Direction.D);
    }

    @Override
    protected void KeyEscape() {
        this.maze.setPause(true);
        game.popView();
    }

    @Override
    protected void KeyEnter() {

    }

    @Override
    protected void AnyKey() {
    }

}
