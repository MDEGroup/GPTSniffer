import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class CirclesAndLineExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // create a pane to hold the circles and line
        Pane pane = new Pane();
        
        // create a random number generator
        Random random = new Random();
        
        // create the first circle
        double centerX1 = random.nextDouble() * (pane.getWidth() - 30) + 15;
        double centerY1 = random.nextDouble() * (pane.getHeight() - 30) + 15;
        Circle circle1 = new Circle(centerX1, centerY1, 15);
        circle1.setFill(Color.RED);
        
        // create the second circle
        double centerX2 = random.nextDouble() * (pane.getWidth() - 30) + 15;
        double centerY2 = random.nextDouble() * (pane.getHeight() - 30) + 15;
        Circle circle2 = new Circle(centerX2, centerY2, 15);
        circle2.setFill(Color.BLUE);
        
        // create the line between the circles
        Line line = new Line(centerX1, centerY1, centerX2, centerY2);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(2.0);
        
        // calculate the distance between the centers of the circles
        double distance = Math.sqrt(Math.pow(centerX2 - centerX1, 2) + Math.pow(centerY2 - centerY1, 2));
        
        // create the text showing the distance between the centers
        Text distanceText = new Text((centerX1 + centerX2) / 2, (centerY1 + centerY2) / 2, String.format("%.2f", distance));
        distanceText.setFill(Color.BLACK);
        distanceText.setStroke(Color.WHITE);
        distanceText.setStrokeWidth(2.0);
        
        // add the circles, line, and text to the pane
        pane.getChildren().addAll(circle1, circle2, line, distanceText);
        
        // create a scene and add the pane to it
        Scene scene = new Scene(pane, 400, 300);
        
        // set the stage's title and scene, then show the stage
        primaryStage.setTitle("Circles and Line Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

