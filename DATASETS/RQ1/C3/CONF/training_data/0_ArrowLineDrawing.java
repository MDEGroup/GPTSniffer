import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class ArrowLineExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // create a pane to hold the arrow line
        Pane pane = new Pane();
        
        // define the starting and ending points of the arrow line
        double startX = 50;
        double startY = 100;
        double endX = 250;
        double endY = 100;
        
        // create a line object to represent the arrow line
        Line line = new Line(startX, startY, endX, endY);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(2.0);
        
        // create a polygon object to represent the arrowhead of the arrow line
        Polygon arrowhead = new Polygon();
        arrowhead.getPoints().addAll(
                endX, endY,
                endX - 10, endY - 5,
                endX - 10, endY + 5);
        arrowhead.setFill(Color.BLACK);
        
        // add the line and arrowhead to the pane
        pane.getChildren().addAll(line, arrowhead);
        
        // create a scene and add the pane to it
        Scene scene = new Scene(pane, 300, 200);
        
        // set the stage's title and scene, then show the stage
        primaryStage.setTitle("Arrow Line Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

