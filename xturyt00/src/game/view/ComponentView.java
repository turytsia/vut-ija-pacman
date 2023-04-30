package game.view;

import java.awt.Graphics;

/**
 * Object interfaces that can be nested under FieldView.
 * 
 * @autor Turtysia Oleksandr (xturyt00)
 * @version %I%, %G%
 */
public interface ComponentView {
    /**
     * Renders the graphic form of the object into the graphic context g.
     * 
     * @param g
     */
    void paintComponent(Graphics g);
}