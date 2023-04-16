package gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import common.Config;
import gui.Game;
import gui.components.Title;

public abstract class View extends JPanel implements KeyListener {
    protected static Config config = new Config();
    protected Game game;
    protected JPanel container = new JPanel();
    private Title title;

    public View(String title, Game game) {
        this.game = game;

        setSize(config.getWidth()-16, config.getHeight());
        setVisible(true);
        setLayout(new BorderLayout());

        
        container.setOpaque(false);
        container.setBackground(new Color(0, 0, 0, 0));
        
        if (title != null) {
            this.title = new Title(title);
            add(this.title, BorderLayout.NORTH);
        }

        add(container, BorderLayout.CENTER);
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
