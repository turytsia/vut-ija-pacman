package game.common;

public interface CommonMazeObject {
    public boolean canMove(CommonField.Direction dir);

    public boolean move(CommonField.Direction dir);

    public boolean isPacman();

    public CommonField getField();
    public void unbindField();
    public int getLives();

    public void setField(CommonField field);

    public int getId();
}
