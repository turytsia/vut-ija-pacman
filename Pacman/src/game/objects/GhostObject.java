package game.objects;

import game.common.CommonField;
import game.common.CommonMazeObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GhostObject extends MazeObject {

    public GhostObject(CommonField field) {
        super(field);
    }

    @Override
    public boolean canMove(CommonField.Direction dir){
        return field.nextField(dir) instanceof PathField;
    }

    public void meetPacman(PathField field){
        if (!field.objects.isEmpty()) {
            for(CommonMazeObject obj : field.objects) {
                if (obj instanceof PacmanObject){
                    ((PacmanObject) obj).gotHit();
                }
            }
        }
    }

    public void startMoving() throws InterruptedException {
        List<CommonField.Direction> directions = Arrays.asList(CommonField.Direction.R, CommonField.Direction.L,
                CommonField.Direction.U, CommonField.Direction.D);
        Random rand_ind = new Random();
        CommonField.Direction dir;
        PacmanObject pacman = this.field.getMaze().getPacman();
        while(true) {
            dir = directions.get(rand_ind.nextInt(directions.size()));

            if (pacman.getFinished() || pacman.getLives() <= 0 || field.getMaze().getPause()) {
                break;
            }

            if (!this.canMove(dir)) {
                continue;
            }
            PathField nextField = (PathField)this.field.nextField(dir);
            this.field.unbindObj(this);

            this.meetPacman(nextField);

            this.setField(nextField);
            nextField.put(this);

            this.field.getMaze().updateHealth();

            this.field.notifyObservers();
            Thread.sleep(250);
        }
    }

    @Override
    public int getLives() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getLives'");
    }

    @Override
    public boolean isPacman() {
        return false;
    }
}
