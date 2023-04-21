package gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.MazeConfigure;
import game.Reviewer;
import game.objects.Maze;
import game.view.MazeView;
import gui.Game;
import gui.components.Button;
import gui.components.Label;

public class GameViewer extends View {
    private Maze maze;

    private int instructionCounter;
    private final Label instructionCounterLabel = new Label("");

    public GameViewer(Game game, File file) {
        super(game);

        setBackground(Color.BLACK);
        
        JPanel footerContainer = new JPanel(new GridLayout(1, 5));
        footerContainer.setOpaque(false);
        footerContainer.setBorder(BorderFactory.createEmptyBorder(0,0,40,0));

        Button prevInstruction = new Button("Prev");
        Button nextInstruction = new Button("Next");
        Button smothMode = new Button("Smooth stepping");
        Button gradualMode = new Button("Gradual stepping");

        Reviewer reviewer = new Reviewer(game, file);
        maze = reviewer.getMaze();

        MazeView mazeView = new MazeView(maze, game);

        mazeView.setPreferredSize(new Dimension(550, 550));
        container.add(mazeView);

        prevInstruction.setPreferredSize(new Dimension(100, 50));

        buttons.add(prevInstruction);
        buttons.add(nextInstruction);
        buttons.add(smothMode);
        buttons.add(gradualMode);

        instructionCounterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructionCounterLabel.setText((instructionCounter + 1) + "/" + reviewer.getInstructions().size());

        footerContainer.add(prevInstruction);
        footerContainer.add(nextInstruction);
        footerContainer.add(instructionCounterLabel);
        footerContainer.add(smothMode);
        footerContainer.add(gradualMode);

        selectButton(activeButton);

        add(footerContainer, BorderLayout.SOUTH);

    }

    @Override
    protected void KeyArrowLeft() {
        selectPrevButton();
        game.update();
    }

    @Override
    protected void KeyArrowUp() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void KeyArrowRight() {
        selectNextButton();
        game.update();
    }

    @Override
    protected void KeyArrowDown() {
        // TODO Auto-generated method stu
    }

    @Override
    protected void KeyEscape() {
        game.popView();
    }

    @Override
    protected void KeyEnter() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void AnyKey() {
        // TODO Auto-generated method stub
    }
    
}
