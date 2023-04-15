package menu.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WallView extends JPanel {
    private Image sprite;

    public WallView() {
        setOpaque(false);
        sprite = new ImageIcon("data/assets/sprites/game/wall.png").getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sprite, 0, 0, getWidth(), getHeight(), this);
    }
}
