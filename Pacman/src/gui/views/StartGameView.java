package gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import common.GhostThread;
import game.MazeConfigure;
import game.objects.GhostObject;
import game.objects.Maze;
import game.view.MazeView;
import gui.Game;
import gui.components.Button;
import gui.components.Label;

public class StartGameView extends View {
    // private final ArrayList<Button> buttons = new ArrayList<Button>();
    // private List<File> maps;
    private int mapIndex = 0;
    // private int activeButton = 0;
    private Maze maze;

    private JPanel mapContent = new JPanel();
    private JLabel mapCounter = new JLabel();

    public StartGameView(Game game, int mapIndex) {
        super("Start game", game);

        this.mapIndex = mapIndex;
        
        setBackground(Color.BLACK);

        container.setLayout(new BorderLayout(2, 2));

        LayoutManager gridLayout = new GridLayout(1, 6, 5, 5);

        JPanel buttonContainer = new JPanel(gridLayout);
        buttonContainer.setOpaque(false);

        Border buttonContainerBorder = getBorder();
        Border buttonContainerMargin = new EmptyBorder(0, 0, 40, 0);
        buttonContainer.setBorder(new CompoundBorder(buttonContainerBorder, buttonContainerMargin));

        Button buttonNext = new Button("Next");
        Button buttonPrev = new Button("Previous");
        Button buttonPlay = new Button("Play");

        buttonNext.setPreferredSize(new Dimension(100, 50));
        buttonPrev.setPreferredSize(new Dimension(100, 50));
        buttonPlay.setPreferredSize(new Dimension(100, 50));

        buttons.add(buttonPrev);
        buttons.add(buttonNext);
        buttons.add(buttonPlay);

        for (Button button : buttons) {
            buttonContainer.add(button);
        }

        mapCounter.setText((mapIndex + 1) + "/" + game.getMapFiles().size());
        mapCounter.setForeground(Color.WHITE);
        mapCounter.setFont(config.getFont("emulogic.ttf", 10f));

        buttonContainer.add(new JLabel());
        buttonContainer.add(mapCounter);
        buttonContainer.add(new JLabel());
        buttonContainer.add(buttonPlay);

        selectButton(buttons.size() - 1);

        JLabel leftBorder = new JLabel();
        JLabel rightBorder = new JLabel();
        JLabel bottomPanel = new JLabel();

        leftBorder.setPreferredSize(new Dimension(20, 20));
        rightBorder.setPreferredSize(new Dimension(20, 20));

        updateMapContent(game.getMapFiles().get(mapIndex));

        buttonPlay.addActionListener(e -> {
            game.pushView(new GameView(maze, game));
            for (GhostObject ghost : maze.ghosts()) {
                GhostThread thread = new GhostThread(ghost);
                thread.start();
            }
        });

        buttonNext.addActionListener(e -> {
            getNextMap();
            game.update();
        });

        buttonPrev.addActionListener(e -> {
            getPrevMap();
            game.update();
        });

        container.add(buttonContainer, BorderLayout.SOUTH);
        container.add(leftBorder, BorderLayout.WEST);
        container.add(rightBorder, BorderLayout.EAST);
        container.add(bottomPanel, BorderLayout.NORTH);
        container.add(mapContent, BorderLayout.CENTER);
    }

    public StartGameView(Game game) {
        this(game, 0);
    }

    private void getNextMap() {
        mapIndex = (mapIndex + 1) % game.getMapFiles().size();
        updateMapContent(game.getMapFiles().get(mapIndex));
    }
    
    private void getPrevMap() {
        mapIndex = (mapIndex-- > 0 ? mapIndex : game.getMapFiles().size() - 1);
        updateMapContent(game.getMapFiles().get(mapIndex));
    }

    private void updateMapContent(File mapFile) {

        mapCounter.setText((mapIndex + 1) + "/" + game.getMapFiles().size());
        
        mapContent.removeAll();
        mapContent.setOpaque(false);
        mapContent.setBackground(new Color(0, 0, 0, 0));
        mapContent.setLayout(new GridLayout(1, 2, 10, 10));

        JPanel map = new JPanel();
        map.setOpaque(false);

        MazeConfigure mazeConfig = new MazeConfigure(mapFile);
        maze = mazeConfig.getMaze();
        JPanel mazePanel = new MazeView(maze, game);

        JPanel mapInfo = new JPanel(new GridLayout(3, 1));
        mapInfo.setOpaque(false);
        JPanel mapInfoStats = new JPanel(new GridLayout(1, 2));
        mapInfoStats.setOpaque(false);
        mapInfoStats.add(new Label("Score: 0.00"));
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

        mapContent.add(mapInfo);
        mapContent.add(mazePanel);
        mapContent.setPreferredSize(new Dimension(config.getWidth(), 20));
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
    }

    @Override
    protected void KeyEnter() {
        buttons.get(activeButton).doClick();
    }

    @Override
    protected void AnyKey() {
    }
}
