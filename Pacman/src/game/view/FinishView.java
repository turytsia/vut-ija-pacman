package game.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * A class representing the graphic form of a finish
 * 
 * @autor Turtysia Oleksandr (xturyt00)
 * @version %I%, %G%
 */
public class FinishView implements ComponentView {
    private FieldView field;
    private Image sprite;

    public FinishView(FieldView field) {
        this.field = field;
        sprite = new ImageIcon("lib/assets/sprites/game/finish.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(sprite, 0, 0, field.getWidth(), field.getHeight(), field);
    }
}
