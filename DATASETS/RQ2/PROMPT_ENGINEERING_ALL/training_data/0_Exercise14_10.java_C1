import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class CylinderDrawing extends Application {
    @Override
    public void start(Stage primaryStage) {
        // create two arcs for the top and bottom of the cylinder
        Arc topArc = new Arc(150, 50, 100, 50, 0, 180);
        Arc bottomArc = new Arc(150, 200, 100, 50, 0, 180);

        // set the stroke type and width for the arcs
        topArc.setStrokeType(StrokeType.INSIDE);
        topArc.setStrokeWidth(5);
        bottomArc.setStrokeType(StrokeType.INSIDE);
        bottomArc.setStrokeWidth(5);

        // set the stroke color and fill color for the arcs
        topArc.setStroke(Color.BLACK);
        topArc.setFill(Color.WHITE);
        bottomArc.setStroke(Color.BLACK);
        bottomArc.setFill(Color.WHITE);

        // set the arc type to ROUND
        topArc.setType(ArcType.ROUND);
        bottomArc.setType(ArcType.ROUND);

        // add dashed stroke to the arcs
        topArc.getStrokeDashArray().addAll(6.0, 21.0);
        bottomArc.getStrokeDashArray().addAll(6.0, 21.0);

        // create a group to hold the arcs
        Group group = new Group(topArc, bottomArc);

        // create a scene and add the group to it
        Scene scene = new Scene(group, 300, 300);

        // set the title of the stage and show it
        primaryStage.setTitle("Cylinder Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}