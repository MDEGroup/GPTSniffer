import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyFace extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        
        gc.setFill(Color.YELLOW);
        gc.fillOval(100, 100, 200, 200);
        gc.setFill(Color.BLACK);
        gc.fillOval(150, 150, 25, 25);
        gc.fillOval(225, 150, 25, 25);
        gc.setFill(Color.RED);
        gc.fillOval(165, 200, 70, 70);

        
        Scene scene = new Scene(canvas);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
