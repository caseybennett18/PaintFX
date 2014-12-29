import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

/**
*This class represents a
*Pencil object.
*
*@author Casey Bennett
*@version 1.0
*/

public class Pencil implements Tool {
    private double x;
    private double y;
    private Color color;
    private Paint paint;


    /**
    *
    *Constructor for Pencil class
    *@param Color - a color value
    */
    public Pencil(Color color) {
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
        paint = g.getStroke();
        x = e.getX();
        y = e.getY();
        g.setStroke(color);
        g.setLineWidth(6);
    }

    /**
     * Tool method that is called when the mouse is dragged.
     * Usually involves updating the drawing location.
     *
     * @param e The mouseevent that fired this onDrag.
     * @param g The current graphics context.
     */
    public void onDrag(MouseEvent e, GraphicsContext g) {
        g.strokeLine(x, y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
    }

    /**
     * Tool method that is called when the mouse is released.
     * Usually involves completing an individual stroke/shape.
     *
     * @param e The mouseevent that fired this onRelease.
     * @param g The current graphics context.
     */
    public void onRelease(MouseEvent e, GraphicsContext g) {
        g.setStroke(paint);
        g.setLineWidth(5);
    }

    /**
     * The name of this tool.
     *
     * @return This tool's name.
     */
    public String getName() {
        return "Pencil";
    }
}