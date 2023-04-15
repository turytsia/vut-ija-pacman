package menu.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import game.MazeConfigure;
import game.objects.GhostObject;
import game.objects.Maze;
import game.objects.PathField;
import game.objects.WallField;
import menu.Button;
import menu.Gradient;
import menu.Label;
import menu.MazeOverview;

public class StartGameView extends View {
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private int activeButton = 0;
    private Maze maze;

    public StartGameView() {
        super(new BorderLayout(2, 2));

        setBackground(Color.BLACK);

        LayoutManager gridLayout = new GridLayout(1, 6, 5, 5);

        JPanel buttonContainer = new JPanel(gridLayout);
        // buttonContainer.setBounds(config.getWidth() - 20 - 200 - 16, 20, 200, 50);
        buttonContainer.setOpaque(false);

        Button buttonNext = new Button("Next");
        Button buttonPrev = new Button("Previous");
        Button buttonPlay = new Button("Play");
    

        buttonNext.setPreferredSize(new Dimension(100, 50));
        buttonPrev.setPreferredSize(new Dimension(100, 50));
        buttonPlay.setPreferredSize(new Dimension(100, 50));

        // buttonNext.setMargin(new Insets(10, 10, 10, 10));
        // buttonPrev.setMargin(new Insets(10, 10, 10, 10));

        buttons.add(buttonPrev);
        buttons.add(buttonNext);
        buttons.add(buttonPlay);

        for (Button button : buttons) {
            buttonContainer.add(button);
        }
        buttonContainer.add(new JLabel());
        buttonContainer.add(new Label("0/0"));
        buttonContainer.add(new JLabel());
        buttonContainer.add(buttonPlay);

        buttons.get(activeButton).setSelect(true);

        add(buttonContainer, BorderLayout.NORTH);

        JLabel leftBorder = new JLabel();
        leftBorder.setPreferredSize(new Dimension(20, 20));
        add(leftBorder, BorderLayout.WEST);

        JLabel rightBorder = new JLabel();
        rightBorder.setPreferredSize(new Dimension(20, 20));
        add(rightBorder, BorderLayout.EAST);

        JLabel bottomPanel = new JLabel();
        bottomPanel.setPreferredSize(new Dimension(20, 60));
        add(bottomPanel, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.setLayout(new GridLayout(1, 2, 10, 10));

        JPanel map = new JPanel();
        map.setOpaque(false);

        MazeConfigure mazeConfig = new MazeConfigure("data/maps/map1.txt");
        maze = mazeConfig.getMaze();
        JPanel mazePanel = new MazeOverview(maze);

        buttonPlay.addActionListener(e -> {
            menu.pushView(new GameView(maze));
        });
        

        JPanel mapInfo = new JPanel(new GridLayout(3, 1));
        mapInfo.setOpaque(false);
        JPanel mapInfoStats = new JPanel(new GridLayout(2, 1));
        mapInfoStats.setOpaque(false);
        mapInfoStats.add(new Label("Score: 0.00"));
        mapInfoStats.add(new Label("Time: 00:00:00"));
        mapInfoStats.add(new Label("Difficulty: 0"));
        mapInfo.add(mapInfoStats);
        String[] data = { "Pac-Man was exploring a new maze,",
                "feeling confident and ready for anything.",
                "As he turned a corner, he saw a ghostly figure ",
                "in the distance, but it quickly disappeared",
                "As he continued to navigate the maze, he noticed that",
                " it was getting darker and the walls were closing in on him." };
        JList<String> story = new JList<>(data);
        story.setOpaque(false);
        story.setBackground(new Color(0, 0, 0, 0));
        story.setForeground(Color.WHITE);
        story.setFocusable(false);

        mapInfo.add(story);

        panel.add(mapInfo);
        panel.add(mazePanel);
        panel.setPreferredSize(new Dimension(config.getWidth(), 20));

        add(panel, BorderLayout.CENTER);

        // add(new Gradient());
    }

    private void selectNext() {
        buttons.get(activeButton).setSelect(false);

        activeButton = (activeButton + 1) % buttons.size();
        buttons.get(activeButton).setSelect(true);
    }

    private void selectPrev() {
        buttons.get(activeButton).setSelect(false);

        activeButton = --activeButton < 0 ? buttons.size() - 1 : activeButton;
        buttons.get(activeButton).setSelect(true);
    }

    @Override
    protected void KeyArrowLeft() {
        selectPrev();
        menu.update();
    }

    @Override
    protected void KeyArrowUp() {
    }

    @Override
    protected void KeyArrowRight() {
        selectNext();
        menu.update();
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
        buttons.get(activeButton).doClick();
    }
}
