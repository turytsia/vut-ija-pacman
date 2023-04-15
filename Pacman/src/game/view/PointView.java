package game.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import game.common.CommonField;
import game.common.CommonMazeObject;

public class PointView implements ComponentView {
    private CommonMazeObject obj;
    private FieldView field;
    private Image sprite;

    public PointView(FieldView field, CommonMazeObject obj) {
        this.obj = obj;
        this.field = field;
        sprite = new ImageIcon("data/assets/sprites/game/points.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(sprite, 0, 0, field.getWidth(), field.getHeight(), field);
    }
}
