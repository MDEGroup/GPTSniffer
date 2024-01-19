import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class RandomPointsOnCircle extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        double centerX = 200;
        double centerY = 200;
        double radius = 100;

        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);

        pane.getChildren().add(circle);

        double[] xCoords = new double[5];
        double[] yCoords = new double[5];

        for (int i = 0; i < 5; i++) {
            double angle = Math.toRadians(i * 72);
            xCoords[i] = centerX + radius * Math.cos(angle);
            yCoords[i] = centerY - radius * Math.sin(angle);

            Circle point = new Circle(xCoords[i], yCoords[i], 5);
            point.setFill(Color.RED);
            point.setStroke(Color.BLACK);

            pane.getChildren().add(point);
        }

        for (int i = 0; i < 4; i++) {
            Line line = new Line(xCoords[i], yCoords[i], xCoords[i + 1], yCoords[i + 1]);
            pane.getChildren().add(line);
        }

        Line line = new Line(xCoords[4], yCoords[4], xCoords[0], yCoords[0]);
        pane.getChildren().add(line);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Random Points on Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}