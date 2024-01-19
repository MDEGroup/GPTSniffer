import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class TwoCircles extends Application {
    
    private static final int CIRCLE_RADIUS = 15;
    
    @Override
    public void start(Stage primaryStage) {
        
        // Create two random points
        Random rand = new Random();
        int x1 = rand.nextInt(400);
        int y1 = rand.nextInt(400);
        int x2 = rand.nextInt(400);
        int y2 = rand.nextInt(400);
        
        // Calculate the distance between the points
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        
        // Create the circles
        Circle circle1 = new Circle(x1, y1, CIRCLE_RADIUS);
        circle1.setFill(javafx.scene.paint.Color.BLUE);
        Circle circle2 = new Circle(x2, y2, CIRCLE_RADIUS);
        circle2.setFill(javafx.scene.paint.Color.GREEN);
        
        // Create the line
        Line line = new Line(x1, y1, x2, y2);
        line.setStroke(javafx.scene.paint.Color.RED);
        
        // Create the distance text
        Text text = new Text((x1 + x2) / 2, (y1 + y2) / 2, String.format("%.2f", distance));
        text.setStroke(javafx.scene.paint.Color.BLACK);
        text.setStyle("-fx-font-size: 14px;");
        
        // Create a group to hold the shapes
        Group group = new Group(circle1, circle2, line, text);
        
        // Create a scene and add the group to it
        Scene scene = new Scene(group, 400, 400);
        
        // Set the stage title and scene, and show the stage
        primaryStage.setTitle("Two Circles and Their Distance");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}