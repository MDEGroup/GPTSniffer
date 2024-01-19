import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class PlotSquareFunction extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Polyline polyline = new Polyline();
        polyline.setStroke(Color.BLUE);

        for (int x = -100; x <= 100; x++) {
            polyline.getPoints().add(x + 200.0);
            polyline.getPoints().add(0.0125 * x * x + 200.0);
        }

        pane.getChildren().add(polyline);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Plot Square Function");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}