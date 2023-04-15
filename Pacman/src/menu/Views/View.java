package menu.Views;

import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import common.Config;

public abstract class View extends JPanel implements KeyListener {
    protected static Config config = new Config();
    protected menu.Menu menu;

    public View(LayoutManager layout) {
        setSize(config.getWidth()-16, config.getHeight());
        setLayout(layout);
        setVisible(true);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        addKeyListener(this);

        setFocusable(true);
        requestFocusInWindow();
    }

    public void setMenu(menu.Menu menu) {
        this.menu = menu;
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

    public void cleanup() {
        removeKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    protected abstract void KeyArrowLeft();

    protected abstract void KeyArrowUp();

    protected abstract void KeyArrowRight();

    protected abstract void KeyArrowDown();

    protected abstract void KeyEscape();

    protected abstract void KeyEnter();

}
