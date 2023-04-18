package common;

import game.objects.GhostObject;

public class GhostThread extends Thread{
    private GhostObject ghost;
    public  GhostThread(GhostObject ghost){
        this.ghost = ghost;
    }
        public void run() {
            try {
                this.ghost.startMoving();
            }
            catch(InterruptedException|IllegalArgumentException e ){
                e.printStackTrace();
            }
        }


}
