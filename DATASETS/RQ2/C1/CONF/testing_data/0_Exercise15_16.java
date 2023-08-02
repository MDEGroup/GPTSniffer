import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TwoCircles extends Application {

    private double distance;
    private Circle circle1, circle2;
    private Line line;
    private Text distanceText;

    @Override
    public void start(Stage primaryStage) {

        // Initialize the circles and line
        circle1 = new Circle(40, 40, 10, Color.BLUE);
        circle2 = new Circle(120, 150, 10, Color.BLUE);
        line = new Line(circle1.getCenterX(), circle1.getCenterY(), circle2.getCenterX(), circle2.getCenterY());
        line.setStroke(Color.RED);

        // Calculate the initial distance and create the distance text
        distance = calculateDistance();
        distanceText = new Text(distance / 2, distance / 2, String.format("%.2f", distance));
        distanceText.setFont(new Font(20));

        // Add event handlers to allow circles to be dragged
        circle1.setOnMouseDragged(event -> {
            circle1.setCenterX(event.getX());
            circle1.setCenterY(event.getY());
            updateLineAndDistance();
        });
        circle2.setOnMouseDragged(event -> {
            circle2.setCenterX(event.getX());
            circle2.setCenterY(event.getY());
            updateLineAndDistance();
        });

        // Create the pane and add the circles, line, and distance text
        Pane pane = new Pane();
        pane.getChildren().addAll(circle1, circle2, line, distanceText);

        // Create the scene and show the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Two Circles");
        primaryStage.show();
    }

    // Calculates the distance between the two circles
    private double calculateDistance() {
        double dx = circle1.getCenterX() - circle2.getCenterX();
        double dy = circle1.getCenterY() - circle2.getCenterY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Updates the line and distance text
    private void updateLineAndDistance() {
        line.setStartX(circle1.getCenterX());
        line.setStartY(circle1.getCenterY());
        line.setEndX(circle2.getCenterX());
        line.setEndY(circle2.getCenterY());
        distance = calculateDistance();
        distanceText.setX((circle1.getCenterX() + circle2.getCenterX()) / 2 - 15);
        distanceText.setY((circle1.getCenterY() + circle2.getCenterY()) / 2 + 15);
        distanceText.setText(String.format("%.2f", distance));
    }

    public static void main(String[] args) {
        launch(args);
    }
}