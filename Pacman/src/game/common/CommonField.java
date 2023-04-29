package game.common;

import java.util.List;

import game.objects.Maze;

/**
 * An interface to the fields that can be placed on the Maze board.
 * CommonMazeObjects can be placed on fields that allow this. The interface
 * extends the Observable interface - it allows dependent objects
 * (Observable.Observer) to be notified of changes made to the field
 * 
 * @autor Oleksandr Turytsia (xturyt00)
 * @autor Kambulat Alakaev (xalaka00)
 * @version %I%, %G%
 */
public interface CommonField extends Observable {

    /**
     * Enum of directions for the movement of maze objects
     */
    public static enum Direction {
        L,
        U,
        R,
        D
    }

    /**
     * Returns the contiguous array in the given dirs direction. It is only relevant
     * for fields on which an object can be inserted (CommonMazeObject). In other
     * cases, it throws an UnsupportedOperationException exception
     * 
     * @param dir The direction of the adjacent field from the current one.
     * @return Adjacent fields in a given direction dirs
     */
    public CommonField nextField(CommonField.Direction dir);

    /**
     * Test if field is empty.
     * 
     * @return Returns the success of the test.
     */
    public boolean isEmpty();

    /**
     * Removes specific object if it exists
     * 
     * @param obj
     */
    public void remove(CommonMazeObject obj);

    /**
     * Returns an object that lies on an array.
     * 
     * @return Field objects. Returns null if the field is empty.
     */
    public List<CommonMazeObject> get();

    /**
     * Returns whether an object (CommonMazeObject) can be placed on the field.
     * 
     * @return Information whether it is possible to insert an object.
     */
    public boolean canMove();

    /**
     * Returns column index where the object is located
     * 
     * @return
     */
    public int getX();
    
    /**
     * Returns row index where the object is located
     * 
     * @return
     */
    public int getY();

    /**
     * Checks whether the field has specific object
     * 
     * @param obj specific object
     * @return true if object is in the field
     */
    public boolean contains(CommonMazeObject obj);

    /**
     * Puts the object onto the field
     * 
     * @param obj object
     */
    public void put(CommonMazeObject obj);

    /**
     * Returns maze to which this field is bound to
     * 
     * @return maze
     */
    public Maze getMaze();
}
