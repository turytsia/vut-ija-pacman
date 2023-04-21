package gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import common.Config;
import game.objects.Maze;
import gui.Game;
import gui.components.Button;
import gui.components.Title;

public abstract class View extends JPanel implements KeyListener {
    protected final ArrayList<Button> buttons = new ArrayList<Button>();
    protected final Config config = new Config();
    protected Maze maze;

    protected int activeButton = 0;
    protected JPanel container = new JPanel();
    protected Game game;
    private Title title;

    private View() {
        setSize(config.getWidth() - 16, config.getHeight());
        setVisible(true);
        setLayout(new BorderLayout());

        container.setOpaque(false);
        container.setBackground(new Color(0, 0, 0, 0));

        add(container, BorderLayout.CENTER);
    }

    private View(String title) {
        this();
        this.title = new Title(title);
        add(this.title, BorderLayout.NORTH);
    }

    public View(Game game, Maze maze, String title) {
        this(title);
        this.game = game;
        this.maze = maze;
    }

    public View(Game game, Maze maze) {
        this(maze.getMazeName());
        this.game = game;
        this.maze = maze;
    }

    public View(Game game, String title) {
        this(title);
        this.game = game;
    }

    public View(Game game) {
        this();
        this.game = game;
    }
    
    protected void selectNextButton() {
        selectButton((activeButton + 1) % buttons.size());
    }

    protected void selectPrevButton() {
        selectButton(activeButton - 1 < 0 ? buttons.size() - 1 : activeButton - 1);
    }

    protected void selectButton(int index) {
        buttons.get(activeButton).setSelect(false);

        activeButton = index;
        buttons.get(activeButton).setSelect(true);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        addKeyListener(this);

        setFocusable(true);
        requestFocusInWindow();
    }

    public void setGame(gui.Game game) {
        this.game = game;
    }

    public void cleanup() {
        removeKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 10:
                KeyEnter();
                break;
            case 27:
                KeyEscape();
                break;
            case 37:
                KeyArrowLeft();
                break;
            case 38:
                KeyArrowUp();
                break;
            case 39:
                KeyArrowRight();
                break;
            case 40:
                KeyArrowDown();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        AnyKey();
    }

    protected abstract void KeyArrowLeft();

    protected abstract void KeyArrowUp();

    protected abstract void KeyArrowRight();

    protected abstract void KeyArrowDown();

    protected abstract void KeyEscape();

    protected abstract void KeyEnter();

    protected abstract void AnyKey();

}
