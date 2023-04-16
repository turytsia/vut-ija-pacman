package game.objects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Path;

import com.sun.jdi.PathSearchingVirtualMachine;
import game.common.CommonField;

import javax.tools.Diagnostic;

public class PacmanObject extends MazeObject {
    private boolean has_key;
    private int lives;
    private int score = 0;

    public PacmanObject(CommonField field) {
        super(field);
        this.has_key = false;
        this.lives = 3;
    }

    @Override
    public boolean isPacman() {
        return true;
    }

     @Override
     public boolean canMove(CommonField.Direction dir){
        return field.nextField(dir) instanceof PathField;
     }

     public void eatPoint(PathField field){
        if (field.object instanceof PointObject){
            this.score += 5;
        }
     }

    public int getScore(){
        return this.score;
    }

     @Override
     public boolean move(CommonField.Direction dir){
        if (!this.canMove(dir)){
            return false;
        }
        PathField nextField = (PathField)this.field.nextField(dir);

        this.field.unbindObj();
        this.setField(nextField);

         this.eatPoint(nextField);

        nextField.put(this);

        System.out.println("Actual score: " + this.score);
        this.field.notifyObservers();
        return true;
     }

    @Override
    public int getLives() {
        return lives;
    }
    
}
