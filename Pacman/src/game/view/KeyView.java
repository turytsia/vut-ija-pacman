package game.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * A class representing the graphic form of a key
 * 
 * @autor Turtysia Oleksandr (xturyt00)
 * @version %I%, %G%
 */
public class KeyView implements ComponentView {
    private FieldView field;
    private Image sprite;

    public KeyView(FieldView field) {
        this.field = field;
        sprite = new ImageIcon("lib/assets/sprites/game/key.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(sprite, 0, 0, field.getWidth(), field.getHeight(), field);
    }
}
