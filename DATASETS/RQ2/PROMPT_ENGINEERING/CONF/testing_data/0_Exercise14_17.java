import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HangmanGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a pane to display the hangman drawing
        Pane pane = new Pane();

        // Create a hangman base (ground)
        Line base = new Line(20, 250, 200, 250);

        // Create a vertical post
        Line post = new Line(60, 250, 60, 50);

        // Create a horizontal beam
        Line beam = new Line(60, 50, 150, 50);

        // Create a rope
        Line rope = new Line(150, 50, 150, 100);

        // Create a head
        Circle head = new Circle(150, 125, 25);
        head.setFill(null);
        head.setStroke(Color.BLACK);

        // Add elements to the pane
        pane.getChildren().addAll(base, post, beam, rope, head);

        // Create a scene and set it in the stage
        Scene scene = new Scene(pane, 220, 280);
        primaryStage.setTitle("Hangman Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}