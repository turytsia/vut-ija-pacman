package gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.objects.Maze;
import gui.Game;
import gui.components.Button;
import gui.components.Label;

/**
 * This class represents view when player loses
 * the game. (Lives <= 0).
 * 
 * Here user can observe his results of the game, exit
 * back or watch replay of this game.
 * 
 * @autor Oleksandr Turytsia (xturyt00)
 * @version %I%, %G%
 */
public class LoserView extends View {
    /* PANELS */
    private final JPanel center = new JPanel(new GridLayout(10, 1));
    private final JPanel leftMargin = new JPanel();
    private final JPanel rightMargin = new JPanel();
    private final JPanel buttonContainer = new JPanel(new GridLayout(1, 2, 10, 10));
    private final JPanel footer = new JPanel();

    /* BUTTONS */
    private final Button buttonReplay = new Button("Watch replay");
    private final Button buttonOkay = new Button("Okay");

    private final List<File> replayFiles = config.getFiles("data/replays");

    public LoserView(Game game, Maze maze) {
        super(game, maze, "YOU LOSE!!!");

        setBackground(Color.BLACK);

        container.setLayout(new BorderLayout());
        center.setOpaque(false);

        leftMargin.setPreferredSize(new Dimension(350, 10));
        rightMargin.setPreferredSize(new Dimension(350, 10));

        leftMargin.setOpaque(false);
        rightMargin.setOpaque(false);

        container.add(leftMargin, BorderLayout.WEST);
        container.add(rightMargin, BorderLayout.EAST);

        Label titleText = new Label("Next time you got it!", 15);
        Label scoreText = maze.getMazeComponent().getScoreText();
        Label mapText = new Label("Map: " + maze.getMazeName());

        titleText.setHorizontalAlignment(SwingConstants.CENTER);
        scoreText.setHorizontalAlignment(SwingConstants.CENTER);
        mapText.setHorizontalAlignment(SwingConstants.CENTER);

        center.add(titleText);
        center.add(scoreText);
        center.add(mapText);

        center.add(new JLabel());
        center.add(new JLabel());
        center.add(new JLabel());
        center.add(new JLabel());
        center.add(new JLabel());

        buttonContainer.setOpaque(false);

        center.add(buttonContainer);

        footer.setPreferredSize(new Dimension(10, 100));
        footer.setOpaque(false);

        container.add(center, BorderLayout.CENTER);
        container.add(footer, BorderLayout.SOUTH);

        buttonReplay.addActionListener(e -> {
            game.pushView(new GameViewer(game, replayFiles.get(replayFiles.size() - 1)));
        });

        buttonOkay.addActionListener(e -> {
            KeyEscape();
        });

        buttons.add(buttonReplay);
        buttons.add(buttonOkay);

        for (Button button : buttons) {
            buttonContainer.add(button);
        }

        selectButton(buttons.size() - 1);
    }

    @Override
    protected void KeyArrowLeft() {
        selectPrevButton();
        game.update();
    }

    @Override
    protected void KeyArrowUp() {
    }

    @Override
    protected void KeyArrowRight() {
        selectNextButton();
        game.update();
    }

    @Override
    protected void KeyArrowDown() {
    }

    @Override
    protected void KeyEscape() {
        game.popView();
        game.swapView(new StartGameView(game, config.getMaps().indexOf(maze.getMazeFile())));
    }

    @Override
    protected void KeyEnter() {
        buttons.get(activeButton).doClick();
    }

    @Override
    protected void AnyKey() {
    }
}
