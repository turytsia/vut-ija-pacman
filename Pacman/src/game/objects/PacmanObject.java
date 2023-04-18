package game.objects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Path;

import com.sun.jdi.PathSearchingVirtualMachine;
import game.common.CommonField;

import javax.tools.Diagnostic;

public class PacmanObject extends MazeObject {
    private boolean has_key;
    private boolean finished;
    private int lives;
    private int score = 0;
    private CommonField.Direction dir;
    private FinishObject finish_pos;


    public PacmanObject(CommonField field) {
        super(field);
        this.has_key = false;
        this.lives = 3;
        this.finished = false;
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
        if (!field.objects.isEmpty()){
            if (field.objects.get(0) instanceof PointObject){
                this.score += 5;
                field.unbindObj();
            }
        }
     }

    public int getScore(){
        return this.score;
    }
    public void setDir(CommonField.Direction dir){
        this.dir = dir;
    }

    public CommonField.Direction getDir(){
        return this.dir;
    }

    public void findKey(PathField field){
        if (!field.objects.isEmpty()) {
            if (field.objects.get(0) instanceof KeyObject) {
                this.has_key = true;
                field.unbindObj();
            }
        }
    }

    public boolean getFinished(){
        return this.finished;
    }

    public void passGates(PathField field){
        if (!field.objects.isEmpty()) {
            if(field.objects.get(0) instanceof FinishObject){
                if (this.has_key){
                    System.out.println("CONGRATULATIONS!!!");
                    this.finished = true;
                }
            }
        }
    }

    public void meetGHost(PathField field){
        if (!field.objects.isEmpty()) {
            if(field.objects.get(0) instanceof GhostObject){
               this.lives -= 1;
            }
        }
    }

     @Override
     public boolean move(CommonField.Direction dir){
        if (!this.canMove(dir)){
            return false;
        }
        PathField nextField = (PathField)this.field.nextField(dir);

        this.field.unbindObj();

        this.eatPoint(nextField);
        this.findKey(nextField);
        this.passGates(nextField);
        this.meetGHost(nextField);

        this.setField(nextField);
        this.setDir(dir);


        nextField.put(this);

        this.field.getMaze().updateHealth();
        this.field.getMaze().updateScore();

        this.field.notifyObservers();

        return true;
     }

    @Override
    public int getLives() {
        return lives;
    }
    
}
