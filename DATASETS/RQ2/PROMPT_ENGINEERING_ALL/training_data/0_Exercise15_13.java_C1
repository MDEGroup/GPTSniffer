import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsideRectangle extends Application {

    private Rectangle rectangle;
    private Text message;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a canvas to draw on
        Canvas canvas = new Canvas(400, 200);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create the rectangle and add it to the pane
        rectangle = new Rectangle(100, 60, 100, 40);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        // Create the message text and add it to the pane
        message = new Text();
        message.setFont(Font.font(18));
        message.setX(10);
        message.setY(30);

        // Create a pane to hold the rectangle and the message
        Pane root = new Pane(canvas, rectangle, message);

        // Create a scene and add it to the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set up the mouse event handler
        scene.setOnMouseMoved(this::handleMouseMoved);
    }

    private void handleMouseMoved(MouseEvent event) {
        double mouseX = event.getX();
        double mouseY = event.getY();

        if (rectangle.contains(mouseX, mouseY)) {
            message.setText("Mouse point is inside the rectangle.");
        } else {
            message.setText("Mouse point is outside the rectangle.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}