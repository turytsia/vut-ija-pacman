package menu;

import java.awt.Color;

import javax.swing.JLabel;

import common.Config;

public class Label extends JLabel {
    private static Config config = new Config();
    public Label(String text) {
        super(text);
        setFont(config.getFont(10));
        setForeground(Color.WHITE);
    }
}
