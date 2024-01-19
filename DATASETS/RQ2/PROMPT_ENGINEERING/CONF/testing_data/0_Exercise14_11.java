import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class SmileyFacePainter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a pane to hold the smiley face
        Pane pane = new Pane();

        // Create the head (a yellow circle)
        Circle head = new Circle(150, 150, 100);
        head.setFill(Color.YELLOW);
        head.setStroke(Color.BLACK);

        // Create the left eye (a white circle)
        Circle leftEye = new Circle(120, 120, 20);
        leftEye.setFill(Color.WHITE);
        leftEye.setStroke(Color.BLACK);

        // Create the right eye (a white circle)
        Circle rightEye = new Circle(180, 120, 20);
        rightEye.setFill(Color.WHITE);
        rightEye.setStroke(Color.BLACK);

        // Create the smile (an arc)
        Arc smile = new Arc(150, 170, 60, 40, 0, 180);
        smile.setFill(Color.WHITE);
        smile.setStroke(Color.BLACK);
        smile.setType(ArcType.OPEN);

        // Add all the shapes to the pane
        pane.getChildren().addAll(head, leftEye, rightEye, smile);

        // Create the scene and set it in the stage
        Scene scene = new Scene(pane, 300, 300);

        // Set the stage title
        primaryStage.setTitle("Smiley Face Painter");

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}