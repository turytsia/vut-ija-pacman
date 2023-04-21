package common;

import game.common.CommonField;

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
            e.printStackTrace();
        }
    }
}
