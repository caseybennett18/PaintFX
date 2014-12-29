import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
*
*This class represents a
*Rectangle Object.
*@author Casey Bennett
*@version 1.0
*/

public class Rectangle implements Tool {
    private double x;
    private double y;
    private Color color;

    /**
    *
    *Constructor for Rectangle class
    *@param color- a color value
    */
    public Rectangle(Color color) {
        this.color = color;
    }

    /**
     * Tool method that is called when the mouse is pressed.
     * Usually involves beginning drawing something.
     *
     * @param e The mouseevent that fired this onPress.
     * @param g The current graphics context.
     */
    public void onPress(MouseEvent e, GraphicsContext g) {
        x = e.getX();
        y = e.getY();
    }

    /**
     * Tool method that is called when the mouse is dragged.
     * Usually involves updating the drawing location.
     *
     * @param e The mouseevent that fired this onDrag.
     * @param g The current graphics context.
     */
    public void onDrag(MouseEvent e, GraphicsContext g) {
        g.fillRect(x, y, e.getX() - x, e.getY() - y);
    }

    /**
     * Tool method that is called when the mouse is released.
     * Usually involves completing an individual stroke/shape.
     *
     * @param e The mouseevent that fired this onRelease.
     * @param g The current graphics context.
     */
    public void onRelease(MouseEvent e, GraphicsContext g) {
        g.fillRect(x, y, e.getX() - x, e.getY() - y);
        g.setFill(color);
    }

    /**
     * The name of this tool.
     *
     * @return This tool's name.
     */
    public String getName() {
        return "Rectangle";
    }
}