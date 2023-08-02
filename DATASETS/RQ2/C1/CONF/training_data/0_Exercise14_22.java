import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;

public class TwoCircles extends Application {

    private final int RADIUS = 15;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a Group to hold the circles and line
        Group root = new Group();

        // Create the two circles with random centers
        Random random = new Random();
        Circle circle1 = new Circle(random.nextInt(WINDOW_WIDTH), random.nextInt(WINDOW_HEIGHT), RADIUS, Color.RED);
        Circle circle2 = new Circle(random.nextInt(WINDOW_WIDTH), random.nextInt(WINDOW_HEIGHT), RADIUS, Color.BLUE);

        // Calculate the line endpoints to avoid crossing inside the circles
        Point2D point1 = new Point2D(circle1.getCenterX(), circle1.getCenterY());
        Point2D point2 = new Point2D(circle2.getCenterX(), circle2.getCenterY());
        Point2D direction = point2.subtract(point1).normalize();
        Point2D offset1 = direction.multiply(RADIUS);
        Point2D offset2 = direction.multiply(-RADIUS);
        Point2D lineStart = point1.add(offset1);
        Point2D lineEnd = point2.add(offset2);

        // Create the line with the calculated endpoints
        Line line = new Line(lineStart.getX(), lineStart.getY(), lineEnd.getX(), lineEnd.getY());
        line.setStrokeWidth(2);
        line.setStroke(Color.GREEN);

        // Add the circles and line to the root Group
        root.getChildren().addAll(circle1, circle2, line);

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Two Circles");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}