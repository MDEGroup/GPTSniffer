import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;

public class KochSnowflakeFractal extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(400, 400);
        root.getChildren().add(canvas);

        drawKochSnowflake(canvas.getGraphicsContext2D(), 400, 350, 400, 0, 5);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Koch Snowflake Fractal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void drawKochSnowflake(GraphicsContext context, double x1, double y1, double x2, double y2, int depth) {
        if (depth == 0) {
            context.setStroke(Color.BLUE);
            context.strokeLine(x1, y1, x2, y2);
        } else {
            double deltaX = (x2 - x1) / 3;
            double deltaY = (y2 - y1) / 3;

            double xA = x1 + deltaX;
            double yA = y1 + deltaY;
            double xB = x1 + 2 * deltaX;
            double yB = y1 + 2 * deltaY;
            double xC = (x1 + x2) / 2 + Math.cos(Math.toRadians(60)) * deltaY;
            double yC = (y1 + y2) / 2 + Math.sin(Math.toRadians(60)) * deltaY;

            drawKochSnowflake(context, x1, y1, xA, yA, depth - 1);
            drawKochSnowflake(context, xA, yA, xC, yC, depth - 1);
            drawKochSnowflake(context, xC, yC, xB, yB, depth - 1);
            drawKochSnowflake(context, xB, yB, x2, y2, depth - 1);
        }
    }
}