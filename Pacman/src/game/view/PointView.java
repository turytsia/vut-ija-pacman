package game.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * A class representing the graphic form of a point
 * 
 * @autor Turtysia Oleksandr (xturyt00)
 * @version %I%, %G%
 */
public class PointView implements ComponentView {
    private FieldView field;
    private Image sprite;

    public PointView(FieldView field) {
        this.field = field;
        sprite = new ImageIcon("data/assets/sprites/game/points.png").getImage();
        field.setPreferredSize(new Dimension(20, 20));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(sprite, 0, 0, field.getWidth(), field.getHeight(), field);
    }
}
