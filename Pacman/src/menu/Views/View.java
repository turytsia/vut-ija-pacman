package menu.Views;

import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import common.Config;

public abstract class View extends ViewController {
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

    public void cleanup() {
        removeKeyListener(this);
    }

}
