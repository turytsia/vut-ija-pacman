package gui.components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.Config;

public class Background extends JLabel {

    private static Config config = new Config();

    private Background(Image background) {
        super(new ImageIcon(background));

        setVisible(true);
        setLayout(null);
        setBounds(0, 0, config.getWidth(), config.getHeight());
    }

    public Background(String path) {
        this(new ImageIcon(path)
                .getImage()
                .getScaledInstance(config.getWidth(), config.getHeight(), Image.SCALE_DEFAULT));
    }
}
