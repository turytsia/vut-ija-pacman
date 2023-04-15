package game.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;

import game.common.CommonMazeObject;

public class GhostView implements ComponentView {
    private CommonMazeObject obj;
    private FieldView field;
    private Image sprite;

    public GhostView(FieldView field, CommonMazeObject obj) {
        this.obj = obj;
        this.field = field;
        sprite = new ImageIcon("data/assets/sprites/game/ghost.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(sprite, 0, 0, field.getWidth(), field.getHeight(), field);
    }
}
