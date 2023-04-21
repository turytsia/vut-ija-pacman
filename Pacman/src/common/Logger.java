package common;

import game.common.CommonField;
import game.objects.Maze;
import game.objects.MazeObject;

public class Logger {
    private MazeObject obj;
    private Maze maze;

    public Logger(MazeObject obj) {
        this.obj = obj;
        this.maze = obj.getField().getMaze();

        //TODO log map
    }

    public void log(CommonField.Direction dir) {
        //TODO log direction where obj moved
        System.out.println(obj.getClass().getName() + obj.getId() + " " + dir);
    }
}
