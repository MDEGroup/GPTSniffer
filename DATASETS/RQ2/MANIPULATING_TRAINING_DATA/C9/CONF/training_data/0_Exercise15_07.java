import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleColor extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create a circle with radius 50 at the center of the pane
        Circle circle = new Circle(150, 150, 50);

        // Set the initial color of the circle to black
        circle.setFill(Color.BLACK);

        // Add event handlers to change the color of the circle when the mouse button is pressed or released
        circle.setOnMousePressed(event -> circle.setFill(Color.WHITE));
        circle.setOnMouseReleased(event -> circle.setFill(Color.BLACK));

        // Create the pane and add the circle
        Pane pane = new Pane();
        pane.getChildren().add(circle);

        // Create the scene and show the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Color");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}