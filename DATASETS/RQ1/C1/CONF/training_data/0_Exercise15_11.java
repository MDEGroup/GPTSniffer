import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class CircleMove extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create a circle with radius 50 at the center of the pane
        Circle circle = new Circle(150, 150, 50);
        circle.setFill(Color.RED);

        // Add an event handler to move the circle when the arrow keys are pressed
        circle.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            if (keyCode == KeyCode.UP) {
                circle.setCenterY(circle.getCenterY() - 10);
            } else if (keyCode == KeyCode.DOWN) {
                circle.setCenterY(circle.getCenterY() + 10);
            } else if (keyCode == KeyCode.LEFT) {
                circle.setCenterX(circle.getCenterX() - 10);
            } else if (keyCode == KeyCode.RIGHT) {
                circle.setCenterX(circle.getCenterX() + 10);
            }
        });

        // Set the focus to the circle so that it can receive key events
        circle.requestFocus();

        // Create the pane and add the circle
        Pane pane = new Pane();
        pane.getChildren().add(circle);

        // Create the scene and show the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Move");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}