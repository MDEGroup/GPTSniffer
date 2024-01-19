import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DisplayStopSign extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Polygon octagon = new Polygon();
        octagon.setStroke(Color.RED);
        octagon.setFill(Color.RED);
        for (int i = 0; i < 8; i++) {
            double angle = 2 * Math.PI / 8 * i;
            double x = 100 + 80 * Math.cos(angle);
            double y = 100 - 80 * Math.sin(angle);
            octagon.getPoints().addAll(x, y);
        }

        Label stopLabel = new Label("STOP");
        stopLabel.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        stopLabel.setTextFill(Color.WHITE);
        stopLabel.setLayoutX(50);
        stopLabel.setLayoutY(85);
        stopLabel.setTextAlignment(TextAlignment.CENTER);

        pane.getChildren().addAll(octagon, stopLabel);

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Display STOP Sign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}