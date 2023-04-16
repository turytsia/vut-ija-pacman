package gui.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import common.Config;
import gui.views.LoadGameView;

public class Button extends JButton {
    private static Config config = new Config();

    public Button(String text) {
        super(text);

        setFont(config.getFont("emulogic.ttf",10f));
        setForeground(Color.WHITE);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setFocusable(false);
        // setIcon(new ImageIcon("data/assets/sprites/game/ghost.png"));
    }
    
    public void setSelect(boolean hasSelect) {
        setBorderPainted(hasSelect);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, false));
    }
}
