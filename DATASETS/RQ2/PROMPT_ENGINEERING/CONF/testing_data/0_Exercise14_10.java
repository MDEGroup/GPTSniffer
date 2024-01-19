import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class CylinderDisplay extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a pane to hold the cylinder
        Pane pane = new Pane();

        // Create the top ellipse of the cylinder
        Arc topEllipse = new Arc(100, 100, 60, 40, 0, 360);
        topEllipse.setFill(null);
        topEllipse.setStrokeWidth(2);
        topEllipse.setStrokeDashArray(6.0, 21.0); // Adding dashed stroke
        topEllipse.setStrokeLineCap(null);

        // Create the bottom ellipse of the cylinder
        Arc bottomEllipse = new Arc(100, 200, 60, 40, 0, 360);
        bottomEllipse.setFill(null);
        bottomEllipse.setStrokeWidth(2);
        bottomEllipse.setStrokeDashArray(6.0, 21.0); // Adding dashed stroke
        bottomEllipse.setStrokeLineCap(null);

        // Create the vertical lines connecting the ellipses
        Line leftLine = new Line(40, 100, 40, 200);
        Line rightLine = new Line(160, 100, 160, 200);

        // Add all shapes to the pane
        pane.getChildren().addAll(topEllipse, bottomEllipse, leftLine, rightLine);

        // Create a scene and set it in the stage
        Scene scene = new Scene(pane, 200, 300);

        // Set the stage title
        primaryStage.setTitle("Cylinder Display");

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}