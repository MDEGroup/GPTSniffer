import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DisplayGrid extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Create horizontal lines
        Line line1 = new Line(10, 50, 290, 50);
        Line line2 = new Line(10, 100, 290, 100);

        // Create vertical lines
        Line line3 = new Line(50, 10, 50, 290);
        Line line4 = new Line(100, 10, 100, 290);

        // Set line colors
        line1.setStroke(Color.BLUE);
        line2.setStroke(Color.BLUE);
        line3.setStroke(Color.RED);
        line4.setStroke(Color.RED);

        // Add lines to the pane
        pane.getChildren().addAll(line1, line2, line3, line4);

        // Create a scene and set it to the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("3x3 Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}