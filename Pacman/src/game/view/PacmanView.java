package game.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import game.common.CommonMazeObject;

public class PacmanView implements ComponentView {

    private CommonMazeObject obj;
    private FieldView field;
    private Image sprite;

    public PacmanView(FieldView field, CommonMazeObject obj) {
        this.obj = obj;
        this.field = field;
        sprite = new ImageIcon("data/assets/sprites/game/pacman.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(sprite, 0, 0, field.getWidth(), field.getHeight(), field);
    }

}
