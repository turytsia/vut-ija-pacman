package common;

import game.common.CommonField;

/**
 * Class that creates new thread for a pacman (When A* algorithm is used).
 * 
 * @author Kambulat Alakaev (xalaka00)
 * @version %I%, %G%
 */
public class PacmanThread extends Thread {
    private CommonField targetField;

    public PacmanThread(CommonField targetField) {
        this.targetField = targetField;
    }

    public void run() {
        try {
            AStar algorithm = new AStar(targetField);
            algorithm.startAStar();
        } catch (InterruptedException | IllegalArgumentException e) {

        }
    }
}
