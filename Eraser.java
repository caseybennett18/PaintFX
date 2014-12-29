import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

/**
*
*This class represents
*an Eraser object.
*@author Casey Bennett
*@version 1.0
*/

public class Eraser implements Tool {
    private double x;
    private double y;
    private Paint color;


    /**
     * Tool method that is called when the mouse is pressed.
     * Usually involves beginning drawing something.
     *
     * @param e The mouseevent that fired this onPress.
     * @param g The current graphics context.
     */
    public void onPress(MouseEvent e, GraphicsContext g) {
        color = g.getStroke();
        x = e.getX();
        y = e.getY();
        g.setStroke(Color.WHITE);
        g.setLineWidth(20);
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
        g.setStroke(color);
        g.setLineWidth(5);
    }

    /**
     * The name of this tool.
     *
     * @return This tool's name.
     */
    public String getName() {
        return "Eraser";
    }
}