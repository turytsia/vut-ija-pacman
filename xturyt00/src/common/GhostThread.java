package common;

import game.objects.GhostObject;

/**
 * Class that creates another thread for the ghost.
 * 
 * @author Kambulat Alakaev (xalaka00)
 * @version %I%, %G%
 */
public class GhostThread extends Thread {
    private GhostObject ghost;

    public GhostThread(GhostObject ghost) {
        this.ghost = ghost;
    }

    public void run() {
        try {
            this.ghost.startMoving();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}
