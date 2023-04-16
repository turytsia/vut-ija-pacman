package menu;

import common.Config;
import menu.Views.MainView;
import menu.Views.View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class creates menu
 */
public class Menu extends JFrame {
    private Config config = new Config();
    private ArrayList<View> views = new ArrayList<>();

    public Menu(View defaultView) {
        super("Pacman");

        setVisible(true); //make window visible
        setSize(config.getWidth(), config.getHeight()); //set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close behaviour for window
        setResizable(false); //resizable
        setLayout(null);

        ImageIcon ic = new ImageIcon("data/assets/sprites/icon.png"); //logo in window
        setIconImage(ic.getImage());
        

        defaultView.setMenu(this);

        views.add(defaultView);
        add(defaultView);

        update();
    }
    
    public void update(){
        revalidate();
        repaint();
    }

    private View getCurrentView() {
        return views.get(views.size() - 1);
    }
    
    private boolean isEmpty() {
        return getCurrentView() instanceof MainView;
    }

    public void swapView(View view) {
        View current = getCurrentView();

        view.setMenu(this);

        views.remove(current);
        views.add(view);

        current.cleanup();
        remove(current);
        add(view);

        update();
    }

    public void pushView(View view) {
        View current = getCurrentView();
        views.add(view);

        view.setMenu(this);

        current.cleanup();
        remove(current);    
        add(view);

        update();
    }

    public void popView() {
        if (isEmpty())
            return;

        View current = getCurrentView();

        views.remove(views.size() - 1);
        current.cleanup();
        remove(current);
        add(getCurrentView());

        update();
    }

}
