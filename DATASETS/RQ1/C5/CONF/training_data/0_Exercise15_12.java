import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CircleMouseHover extends Application {
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, 60, 50);
        Text message = new Text();

        Pane pane = new Pane();
        pane.getChildren().addAll(circle, message);

        pane.setOnMouseMoved(e -> {
            double x = e.getX();
            double y = e.getY();

            if (circle.contains(x, y)) {
                message.setText("Mouse is inside the circle");
            } else {
                message.setText("Mouse is outside the circle");
            }
            message.setX(x);
            message.setY(y);
        });

        Scene scene = new Scene(pane, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Mouse Hover");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}