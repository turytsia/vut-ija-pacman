package game.objects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Path;

import com.sun.jdi.PathSearchingVirtualMachine;
import common.Logger;
import game.common.CommonField;
import game.common.CommonMazeObject;

import javax.tools.Diagnostic;

public class PacmanObject extends MazeObject {
    private boolean has_key;
    private boolean finished;
    private int lives;
    private int score = 0;
    private CommonField.Direction dir;
    private Logger logger;

    public PacmanObject(CommonField field) {
        super(field);
        this.has_key = false;
        this.lives = 3;
        this.finished = false;
        this.logger = new Logger(this);
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
            CommonMazeObject point = field.objects.get(0);
            if (point instanceof PointObject){
                this.score += 5;
                field.unbindObj(point);
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
            CommonMazeObject key = field.objects.get(0);
            if (key instanceof KeyObject) {
                this.has_key = true;
                field.unbindObj(key);
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

    public void gotHit(){
        this.lives -= 1;
    }

    public void meetGHost(PathField field){
        if (!field.objects.isEmpty()) {
            if(field.objects.get(0) instanceof GhostObject){
               this.gotHit();
            }
        }
    }

     @Override
     public boolean move(CommonField.Direction dir){
        if (!this.canMove(dir)){
            return false;
        }
        PathField nextField = (PathField)this.field.nextField(dir);

        this.field.unbindObj(this);

        this.eatPoint(nextField);
        this.findKey(nextField);
        this.passGates(nextField);
        this.meetGHost(nextField);

        this.setField(nextField);
        this.setDir(dir);


        this.logger.log(dir);

        nextField.put(this);

        this.field.getMaze().updateHealth();
        this.field.getMaze().updateScore();

        this.field.notifyObservers();

        return true;
     }


     public Logger getLogger(){
        return logger;
     }
    @Override
    public int getLives() {
        return lives;
    }
    
}
