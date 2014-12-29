import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
*
*JavaFX class for paint
*@author Casey Bennett
*@version 1.0
*/


public class PaintFX extends Application {

    private Tool tool;
    private ComboBox<Color> comboBox;

    @Override public void start(Stage stage) {

        GridPane gridpane = new GridPane();

        Canvas canvas = new Canvas(400, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        VBox vbox = new VBox(15);

        ColorPicker colors = new ColorPicker(Color.BLACK);
        colors.setOnAction(event -> {
                gc.setStroke(colors.getValue());
                gc.setFill(colors.getValue());
            });

        Label label = new Label("Tools");
        label.setStyle("-fx-font-size: 24px");
        label.setStyle("-fx-font-weight: bold");

        Button rectangle = new Button("Rectangle");
        rectangle.setPrefSize(100, 20);
        rectangle.setOnAction(event ->
            tool = new Rectangle(colors.getValue()));

        Button circle = new Button("Teardrop LOLZ");
        circle.setPrefSize(120, 20);
        circle.setOnAction(event ->
            tool = new Circle(colors.getValue()));

        Button clear = new Button("Eraser");
        clear.setPrefSize(100, 20);
        clear.setOnAction(event ->
            tool = new Eraser());

        Button pencil = new Button("Pencil");
        pencil.setPrefSize(100, 20);
        pencil.setOnAction(event ->
            tool = new Pencil(colors.getValue()));

        vbox.getChildren().addAll(label, colors, pencil,
            rectangle, circle, clear);
        vbox.setStyle("-fx-background-color: #336699;");
        vbox.setAlignment(Pos.TOP_CENTER);

        gridpane.getChildren().addAll(vbox, canvas);
        gridpane.setRowIndex(vbox, 0);
        gridpane.setColumnIndex(vbox, 0);
        gridpane.setRowIndex(canvas, 0);
        gridpane.setColumnIndex(canvas, 1);
        gridpane.getColumnConstraints().add(new ColumnConstraints(125));
        gridpane.getRowConstraints().add(new RowConstraints(500));
        gridpane.getColumnConstraints().add(new ColumnConstraints(400));

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, (event ->
            tool.onPress(event, gc)));
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, (event ->
            tool.onRelease(event, gc)));
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, (event ->
            tool.onDrag(event, gc)));


        Scene scene = new Scene(gridpane);
        stage.setScene(scene);
        stage.setTitle("CS1331 Paint");
        stage.show();
    }
}