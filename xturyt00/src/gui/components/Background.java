package gui.components;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.Config;

/**
 * This class is configured JLabel that is used
 * as background with an image.
 * 
 * @author Oleksandr Turytsia (xturyt00)
 * @version %I%, %G%
 */
public class Background extends JLabel {

    private final static Config config = new Config();

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
