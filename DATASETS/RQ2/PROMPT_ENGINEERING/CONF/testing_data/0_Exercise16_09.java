import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleIntersect extends Application {

    private Rectangle rectangle1;
    private Rectangle rectangle2;
    private TextField rect1XField;
    private TextField rect1YField;
    private TextField rect2XField;
    private TextField rect2YField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Creating rectangles
        rectangle1 = createRectangle(50, 50, 100, 80, Color.BLUE);
        rectangle2 = createRectangle(200, 100, 120, 60, Color.RED);

        // Creating text fields for rectangle coordinates
        rect1XField = createTextField(20, 20);
        rect1YField = createTextField(20, 50);
        rect2XField = createTextField(170, 20);
        rect2YField = createTextField(170, 50);

        // Adding unnecessary labels
        Label rect1Label = new Label("Rectangle 1:");
        Label rect2Label = new Label("Rectangle 2:");

        // Adding rectangles to a layout
        Pane root = new Pane();
        root.getChildren().addAll(rectangle1, rectangle2, rect1XField, rect1YField, rect2XField, rect2YField, rect1Label, rect2Label);

        // Adding unnecessary details to the stage
        primaryStage.setTitle("Rectangle Intersect Checker");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();

        // Adding mouse event handlers
        rectangle1.setOnMouseDragged(e -> dragRectangle(rectangle1, rect1XField, rect1YField, e));
        rectangle2.setOnMouseDragged(e -> dragRectangle(rectangle2, rect2XField, rect2YField, e));
    }

    private Rectangle createRectangle(double x, double y, double width, double height, Color color) {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(color);
        rectangle.setStroke(Color.BLACK);
        return rectangle;
    }

    private TextField createTextField(double x, double y) {
        TextField textField = new TextField();
        textField.setLayoutX(x);
        textField.setLayoutY(y);
        textField.setEditable(false);
        return textField;
    }

    private void dragRectangle(Rectangle rectangle, TextField xField, TextField yField, MouseEvent event) {
        double offsetX = event.getX() - rectangle.getWidth() / 2;
        double offsetY = event.getY() - rectangle.getHeight() / 2;

        rectangle.setX(offsetX);
        rectangle.setY(offsetY);

        xField.setText(Double.toString(rectangle.getX()));
        yField.setText(Double.toString(rectangle.getY()));

        // Adding unnecessary details like updating fields on drag
        System.out.println("Rectangle dragged. X: " + rectangle.getX() + ", Y: " + rectangle.getY());
    }
}