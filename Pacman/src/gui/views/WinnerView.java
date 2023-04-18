package gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import game.MazeConfigure;
import game.objects.Maze;
import gui.Game;
import gui.components.Button;
import gui.components.Label;

public class WinnerView extends View {

    private Maze maze;

    public WinnerView(Game game, Maze maze) {
        super("CONGRATULATIONS!!!", game);

        this.maze = maze;

        container.setLayout(new BorderLayout());

        JPanel center = new JPanel(new GridLayout(10, 1));
        center.setOpaque(false);

        JPanel leftMargin = new JPanel();
        JPanel rightMargin = new JPanel();

        leftMargin.setPreferredSize(new Dimension(350, 10));
        rightMargin.setPreferredSize(new Dimension(350, 10));

        leftMargin.setOpaque(false);
        rightMargin.setOpaque(false);

        container.add(leftMargin, BorderLayout.WEST);
        container.add(rightMargin, BorderLayout.EAST);
        

        Label titleText = new Label("Winner, winner - chicken dinner!", 15);
        Label scoreText = maze.getScoreText();
        Label mapText = new Label("Map: "+maze.getMazeName());

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

        JPanel buttonContainer = new JPanel(new GridLayout(1, 2, 10 , 10));
        buttonContainer.setOpaque(false);

        center.add(buttonContainer);

        JPanel footer = new JPanel();
        footer.setPreferredSize(new Dimension(10, 100));
        footer.setOpaque(false);

        container.add(center, BorderLayout.CENTER);
        container.add(footer, BorderLayout.SOUTH);

        Button buttonReplay = new Button("Watch replay");
        Button buttonOkay = new Button("Okay");

        buttonOkay.addActionListener(e -> {
            KeyEscape();
        });

        buttons.add(buttonReplay);
        buttons.add(buttonOkay);

        for (Button button : buttons) {
            buttonContainer.add(button);
        }

        selectButton(buttons.size() - 1);

        setBackground(Color.BLACK);
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
        game.swapView(new StartGameView(game, game.getMapFiles().indexOf(maze.getMazeFile())));
    }

    @Override
    protected void KeyEnter() {
        buttons.get(activeButton).doClick();
    }

    @Override
    protected void AnyKey() {
    }
    
}
