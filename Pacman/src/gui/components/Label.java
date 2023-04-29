package gui.components;

import java.awt.Color;

import javax.swing.JLabel;

import common.Config;

/**
 * This class is configured JLabel that is used
 * as simple text in the game.
 * 
 * @autor Oleksandr Turytsia (xturyt00)
 * @version %I%, %G%
 */
public class Label extends JLabel {
    private static Config config = new Config();

    public Label(String text) {
        this(text, 10);
    }
    
    public Label(String text, float size) {
        super(text);
        setFont(config.getFont("emulogic.ttf", size));
        setForeground(Color.WHITE);
    }
}
