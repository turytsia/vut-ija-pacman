package game.objects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Path;

import game.common.CommonField;

import javax.tools.Diagnostic;

public class PacmanObject extends MazeObject {

    private int lives = 3;

    public PacmanObject(CommonField field) {
        super(field);
    }

    @Override
    public boolean isPacman() {
        return true;
    }

     @Override
     public boolean canMove(CommonField.Direction dir){
        return field.nextField(dir) instanceof PathField;
     }

     @Override
     public boolean move(CommonField.Direction dir){
        if (!this.canMove(dir)){
            return false;
        }
        PathField nextField = (PathField)this.field.nextField(dir);
        // TODO: remove object? But what with the Point object
        this.field.unbindObj();
        this.setField(nextField);
        nextField.put(this);
        this.field.notifyObservers();
        return true;
     }

    @Override
    public int getLives() {
        return lives;
    }
    
}
