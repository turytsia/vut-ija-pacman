package gui.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import common.Config;

/**
 * Component that represents button in the game
 * 
 * @autor Oleksandr Turytsia (xturyt00)
 * @version %I%, %G%
 */
public class Button extends JButton {
    private final static Config config = new Config();

    public Button(String text) {
        super(text);
        setFont(config.getFont("emulogic.ttf",10f));
        setForeground(Color.WHITE);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setFocusable(false);
    }
    
    public void setSelect(boolean hasSelect) {
        setBorderPainted(hasSelect);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, false));
    }
}
