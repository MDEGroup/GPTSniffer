import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class CircleMove extends Application {

    private Circle circle;
    private double dx = 0;
    private double dy = 0;

    @Override
    public void start(Stage primaryStage) {
        
        circle = new Circle(150, 150, 50);
        circle.setFill(Color.RED);

        
        Pane pane = new Pane(circle);

        
        Scene scene = new Scene(pane, 300, 300);

        
        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            if (keyCode == KeyCode.UP) {
                dy -= 5;
            } else if (keyCode == KeyCode.DOWN) {
                dy += 5;
            } else if (keyCode == KeyCode.LEFT) {
                dx -= 5;
            } else if (keyCode == KeyCode.RIGHT) {
                dx += 5;
            }
        });

        
        scene.setOnKeyReleased(event -> {
            KeyCode keyCode = event.getCode();
            if (keyCode == KeyCode.UP) {
                dy = 0;
            } else if (keyCode == KeyCode.DOWN) {
                dy = 0;
            } else if (keyCode == KeyCode.LEFT) {
                dx = 0;
            } else if (keyCode == KeyCode.RIGHT) {
                dx = 0;
            }
        });

        
        javafx.animation.AnimationTimer timer = new javafx.animation.AnimationTimer() {
            @Override
            public void handle(long now) {
                circle.setCenterX(circle.getCenterX() + dx);
                circle.setCenterY(circle.getCenterY() + dy);
            }
        };
        timer.start();

        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Move");
        primaryStage.show();

        
        scene.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}