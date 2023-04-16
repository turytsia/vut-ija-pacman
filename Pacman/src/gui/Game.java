package gui;

import common.Config;
import gui.views.MainView;
import gui.views.View;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Class creates menu
 */
public class Game extends JFrame {
    private Config config = new Config();
    private ArrayList<View> views = new ArrayList<>();

    public Game() {
        super("Pacman");

        setVisible(true); //make window visible
        setSize(config.getWidth(), config.getHeight()); //set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close behaviour for window
        setResizable(false); //resizable
        setLayout(null);

        ImageIcon ic = new ImageIcon("data/assets/sprites/icon.png"); //logo in window
        setIconImage(ic.getImage());
    }

    public void launch(View defaultView) {
        defaultView.setGame(this);

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

        view.setGame(this);

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

        view.setGame(this);

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
