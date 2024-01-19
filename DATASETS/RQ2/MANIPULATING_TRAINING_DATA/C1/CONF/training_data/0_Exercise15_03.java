import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MoveBall extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int RADIUS = 20;
    private static final int SPEED = 50; // pixels per second

    private Circle ball;
    private Pane pane;
    private TranslateTransition transition;

    @Override
    public void start(Stage primaryStage) {
        // Create ball
        ball = new Circle(RADIUS, Color.RED);
        ball.setTranslateX(WIDTH / 2);
        ball.setTranslateY(HEIGHT / 2);

        // Create pane and add ball to it
        pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.getChildren().add(ball);

        // Create transition to move ball
        transition = new TranslateTransition(Duration.seconds(1), ball);
        transition.setByX(0); // start with no movement
        transition.setByY(0); // start with no movement
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);

        // Add event listeners to move ball on arrow key presses
        pane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    moveUp();
                    break;
                case DOWN:
                    moveDown();
                    break;
                case LEFT:
                    moveLeft();
                    break;
                case RIGHT:
                    moveRight();
                    break;
                default:
                    break;
            }
        });
        pane.requestFocus(); // make sure pane has focus for key events

        // Create scene and add pane to it
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Move Ball");
        primaryStage.show();
    }

    private void moveUp() {
        if (ball.getTranslateY() - RADIUS > 0) {
            transition.stop();
            transition.setByX(0);
            transition.setByY(-SPEED);
            transition.play();
        }
    }

    private void moveDown() {
        if (ball.getTranslateY() + RADIUS < HEIGHT) {
            transition.stop();
            transition.setByX(0);
            transition.setByY(SPEED);
            transition.play();
        }
    }

    private void moveLeft() {
        if (ball.getTranslateX() - RADIUS > 0) {
            transition.stop();
            transition.setByX(-SPEED);
            transition.setByY(0);
            transition.play();
        }
    }

    private void moveRight() {
        if (ball.getTranslateX() + RADIUS < WIDTH) {
            transition.stop();
            transition.setByX(SPEED);
            transition.setByY(0);
            transition.play();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}