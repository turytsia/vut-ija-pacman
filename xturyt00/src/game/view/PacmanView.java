package game.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import game.common.CommonField;
import game.common.CommonMazeObject;

/**
 * A class representing the graphic form of a pacman
 * 
 * @author Turtysia Oleksandr (xturyt00)
 * @version 1.0
 */
public class PacmanView implements ComponentView {

    private CommonMazeObject obj;
    private FieldView field;
    private Image sprite;

    public PacmanView(FieldView field, CommonMazeObject obj) {
        this.obj = obj;
        this.field = field;
        this.sprite = new ImageIcon("lib/sprites/game/pacman-right.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        sprite = getPacmanImage(obj.getField().getMaze().getPacman().getDir());

        g.drawImage(sprite, 0, 0, field.getWidth(), field.getHeight(), field);
    }

    private Image getPacmanImage(CommonField.Direction dir) {
        if (dir == null)
            return sprite;

        switch (dir) {
            case U:
                return new ImageIcon("lib/sprites/game/pacman-up.png").getImage();
            case L:
                return new ImageIcon("lib/sprites/game/pacman-left.png").getImage();
            case R:
                return new ImageIcon("lib/sprites/game/pacman-right.png").getImage();
            case D:
                return new ImageIcon("lib/sprites/game/pacman-down.png").getImage();
        }

        return sprite;
    }

}
