import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * This interface represents a Tool object. Tools have some action when they
 * are pressed, dragged, and also released.
 * @author Aaron Friesen
 * @version 1.0
 */
public interface Tool {

    /**
     * Tool method that is called when the mouse is pressed.
     * Usually involves beginning drawing something.
     *
     * @param e The mouseevent that fired this onPress.
     * @param g The current graphics context.
     */
    void onPress(MouseEvent e, GraphicsContext g);

    /**
     * Tool method that is called when the mouse is dragged.
     * Usually involves updating the drawing location.
     *
     * @param e The mouseevent that fired this onDrag.
     * @param g The current graphics context.
     */
    void onDrag(MouseEvent e, GraphicsContext g);

    /**
     * Tool method that is called when the mouse is released.
     * Usually involves completing an individual stroke/shape.
     *
     * @param e The mouseevent that fired this onRelease.
     * @param g The current graphics context.
     */
    void onRelease(MouseEvent e, GraphicsContext g);

    /**
     * The name of this tool.
     *
     * @return This tool's name.
     */
    String getName();
}
