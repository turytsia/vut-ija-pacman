package game.objects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.common.CommonField;

public class PacmanObject extends MazeObject implements KeyListener {

    private int lives = 3;

    public PacmanObject(CommonField field) {
        super(field);
    }

    @Override
    public boolean isPacman() {
        return true;
    }

    @Override
    public int getLives() {
        return lives;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("123");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
