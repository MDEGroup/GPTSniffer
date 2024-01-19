import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlotSineCosineFunctions extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Polyline sinePolyline = new Polyline();
        sinePolyline.setStroke(Color.RED);

        Polyline cosinePolyline = new Polyline();
        cosinePolyline.setStroke(Color.BLUE);

        ObservableList<Double> sinePoints = sinePolyline.getPoints();
        ObservableList<Double> cosinePoints = cosinePolyline.getPoints();
        
        double scaleFactor = 50;

        for (int x = -170; x <= 170; x++) {
            sinePoints.add(x + 200.0);
            sinePoints.add(100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI));

            cosinePoints.add(x + 200.0);
            cosinePoints.add(100 - 50 * Math.cos((x / 100.0) * 2 * Math.PI));
        }

        Text piText = new Text(160, 115, "\u03C0");
        piText.setFont(Font.font("Arial", 16));

        Text minus2piText = new Text(40, 115, "-2\u03C0");
        minus2piText.setFont(Font.font("Arial", 16));

        Text plus2piText = new Text(280, 115, "2\u03C0");
        plus2piText.setFont(Font.font("Arial", 16));

        pane.getChildren().addAll(sinePolyline, cosinePolyline, piText, minus2piText, plus2piText);

        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("Plot Sine and Cosine Functions");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}